package com.gildedrose

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach {
            val item: Item = when (it.name) {
                "Sulfuras, Hand of Ragnaros" -> sulfuras(it)
                "Aged Brie" -> agedBrie(it)
                "Backstage passes to a TAFKAL80ETC concert" -> backstagePasses(it)
                else -> anyItem(it)
            }
            it.name = item.name
            it.quality = item.quality
            it.sellIn = item.sellIn
        }
    }

    private fun agedBrie(item: Item): Item {
        item.sellIn = item.sellIn - 1
        item.quality = plusQuality(item.quality)
        return item
    }

    private fun sulfuras(item: Item): Item {
        item.sellIn = item.sellIn - 1
        return item
    }

    private fun backstagePasses(item: Item): Item {
        item.sellIn = item.sellIn - 1
        if (item.sellIn > 10) {
            item.quality = item.quality + 1
        } else if (item.sellIn > 5) {
            item.quality = item.quality + 2
        } else if (item.sellIn > 0) {
            item.quality = item.quality + 3
        } else {
            item.quality = 0
        }
        return item
    }

    private fun anyItem(item: Item): Item {
        item.sellIn = item.sellIn - 1
        item.quality = minusQuality(item.quality, item.sellIn)
        return item
    }

    private fun plusQuality(quality: Int): Int {
        return if (quality < 50) {
            quality + 1
        } else {
            quality
        }
    }

    private fun minusQuality(quality: Int, sellIn: Int): Int {
        if (quality <= 0) {
            return quality
        } else {
            if (sellIn <= 0) {
                return quality - 2
            }
            return quality - 1
        }
    }

}

