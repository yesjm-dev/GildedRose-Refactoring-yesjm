package com.gildedrose

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        items.forEach {
            val item: Item = when (it.name) {
                "Sulfuras, Hand of Ragnaros" -> it
                "Aged Brie" -> agedBrie(it)
                "Backstage passes to a TAFKAL80ETC concert" -> backstagePasses(it)
                "Conjured Mana Cake" -> conjured(it)
                else -> anyItem(it)
            }
            it.name = item.name
            it.quality = item.quality
            it.sellIn = it.sellIn - 1
        }
    }

    private fun agedBrie(item: Item): Item {
        item.quality = plusQuality(item.quality)
        return item
    }

    private fun backstagePasses(item: Item): Item {
        if (item.sellIn > 10) {
            item.quality = plusQuality(item.quality, 1)
        } else if (item.sellIn > 5) {
            item.quality = plusQuality(item.quality, 2)
        } else if (item.sellIn > 0) {
            item.quality = plusQuality(item.quality, 3)
        } else {
            item.quality = 0
        }
        return item
    }

    private fun conjured(item: Item): Item {
        item.quality = minusQuality(item.quality, item.sellIn, 2)
        return item
    }

    private fun anyItem(item: Item): Item {
        item.quality = minusQuality(item.quality, item.sellIn)
        return item
    }

    private fun plusQuality(quality: Int, value: Int = 1): Int {
        return if (quality < 50) {
            quality + value
        } else {
            quality
        }
    }

    private fun minusQuality(quality: Int, sellIn: Int, value: Int = 1): Int {
        if (quality <= 0) {
            return quality
        } else {
            if (sellIn <= 0) {
                return quality - (value * 2)
            }
            return quality - value
        }
    }

}

