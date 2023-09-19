package com.gildedrose

import com.gildedrose.enum.ItemName

open class Item(
    var name: ItemName,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String {
        return this.name.toString() + ", " + this.sellIn + ", " + this.quality
    }
}