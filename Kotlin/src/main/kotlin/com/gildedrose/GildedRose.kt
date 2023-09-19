package com.gildedrose

import com.gildedrose.enum.ItemName

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != ItemName.AGED_BRIE && items[i].name != ItemName.BACKSTAGE_PASSES) {
                if (items[i].quality > 0) {
                    if (items[i].name != ItemName.SULFURAS) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == ItemName.BACKSTAGE_PASSES) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != ItemName.SULFURAS) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != ItemName.AGED_BRIE) {
                    if (items[i].name != ItemName.BACKSTAGE_PASSES) {
                        if (items[i].quality > 0) {
                            if (items[i].name != ItemName.SULFURAS) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

