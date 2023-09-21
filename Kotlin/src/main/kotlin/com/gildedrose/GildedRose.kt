package com.gildedrose

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach { item ->
            if (item.name == "Sulfuras, Hand of Ragnaros") {
                sulfuras(item)
            }
            if (item.name == "Aged Brie") {
                agedBrie(item)
            }
            if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                backstagePasses(item)
            }
        }
    }

    private fun agedBrie(item: Item) {
        item.sellIn = item.sellIn - 1
        item.quality = plusQuality(item.quality)
    }

    private fun sulfuras(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun backstagePasses(item: Item) {
        item.sellIn = item.sellIn - 1
        if (item.sellIn > 10) {
            item.quality = item.quality + 1
        }
        if (item.sellIn > 5) {
            item.quality = item.quality + 2
        }
        if (item.sellIn > 0) {
            item.quality = item.quality + 3
        } else {
            item.quality = 0
        }
    }

    private fun plusQuality(quality: Int): Int {
        return if (quality in 1..49) {
            quality + 1
        } else {
            quality
        }
    }

    private fun minusQuality(quality: Int, sellIn: Int): Int {
        return if (quality <= 0) {
            quality
        } else {
            if (sellIn < 0) {
                quality - quality
            }
            quality - 1
        }
    }

}

