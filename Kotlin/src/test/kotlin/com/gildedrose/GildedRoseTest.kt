package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `Item의 Quality는 음수가 되지 않는다`() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Item의 Quality는 50을 초과하지 않는다`() {
        val items = listOf(Item("Aged Brie", 0, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Item의 SellIn이 0보다 작거나 같으면 Quality는 2배로 떨어진다`() {
        val items = listOf(Item("Elixir of the Mongoose", 0, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(18, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Aged Brie는 시간이 지날수록 Quality 값이 올라간다`() {
        val items = listOf(Item("Aged Brie", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(1, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Sulfuras는 시간이 지나도 Quality 값이 변하지 않는다`() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 0, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(10, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Backstage passes는 sellIn이 10~ 인 경우 Quality 값이 1 올라간다`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 15, 20))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(21, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Backstage passes는 sellIn이 5~10 인 경우 Quality 값이 2 올라간다`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 49))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(51, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

    @Test
    fun `Backstage passes는 sellIn이 0~5 인 경우 Quality 값이 2 올라간다`() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),)
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(52, app.items[0].quality)
            .also { println("quality: ${app.items[0].quality}") }
    }

}


