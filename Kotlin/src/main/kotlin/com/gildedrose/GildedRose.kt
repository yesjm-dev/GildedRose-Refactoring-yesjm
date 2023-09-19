package com.gildedrose

import com.gildedrose.enum.ItemName

class GildedRose(var items: List<Item>) {
    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != ItemName.SULFURAS) {
                items[i].sellIn = items[i].sellIn - 1
            }
            if (items[i].name != ItemName.AGED_BRIE && items[i].name != ItemName.BACKSTAGE_PASSES) {
                if (items[i].quality > 0) {
                    if (items[i].name != ItemName.SULFURAS) {
                        items[i].quality = minusQuality(items[i].quality)
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = plusQuality(items[i].quality)

                    if (items[i].name == ItemName.BACKSTAGE_PASSES) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = plusQuality(items[i].quality)
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = plusQuality(items[i].quality)
                            }
                        }
                    }
                }
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != ItemName.AGED_BRIE) {
                    if (items[i].name != ItemName.BACKSTAGE_PASSES) {
                        if (items[i].quality > 0) {
                            if (items[i].name != ItemName.SULFURAS) {
                                items[i].quality = minusQuality(items[i].quality)
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = plusQuality(items[i].quality)
                    }
                }
            }
        }
    }

    private fun plusQuality(quality: Int): Int {
        return if (quality in 1..49) {
            quality + 1
        } else {
            quality
        }
    }

    private fun minusQuality(quality: Int): Int {
        return if (quality <= 0) {
            quality
        } else {
            quality - 1
        }
    }

}

