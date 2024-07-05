package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    @Test
    fun `basic test`() {
        //given
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)

        assertEquals(items[0].name, app.items[0].name, "before: ${app.items[0]}")
        assertEquals(items[0].sellIn, app.items[0].sellIn, "before: ${app.items[0]}")
        assertEquals(items[0].quality, app.items[0].quality, "before: ${app.items[0]}")
        //when
        app.update()
        //then
        assertEquals(items[0].name, app.items[0].name, "after: ${app.items[0]}")
        assertEquals(items[0].sellIn, app.items[0].sellIn, "after: ${app.items[0]}") //TODO -1
        assertEquals(items[0].quality, app.items[0].quality, "after: ${app.items[0]}") //TODO -1
    }

    @Test
    fun diff() {
        //given
        val excepted = TestData.expectedOutput
        val app = GildedRose(TestData.items())
        val actual = mutableListOf(Constants.HEADER)
        //when
        for (i in 0..<Constants.DEFAULT_DAYS) {
            actual.add(dayToString(i, app.items))
            app.updateQuality()
        }
        //then
        assertEquals(excepted, actual.allDaysToString())
    }

    @Test
    fun `diff 1000 days`() {
        //given
        val excepted = TestData.days1000Output
        val app = GildedRose(TestData.items())
        val actual = mutableListOf(Constants.HEADER)
        //when
        for (i in 0..1000) {
            actual.add(dayToString(i, app.items))
            app.updateQuality()
        }
        //then
        assertEquals(excepted, actual.allDaysToString())
    }

    @Test
    fun `decrease quality tests`() {
        //given
        val input = mapOf(
            -5 to -5,
            -3 to -3,
            -1 to -1,
            0 to 0,
            1 to 0,
            2 to 1,
            3 to 2,
        )
        input.forEach {
            //when
            val item = Item("", 0, it.key)
            item.decreaseQuality()
            //then
            assertEquals(it.value, item.quality)
        }
    }

    @Test
    fun `increase quality tests`() {
        //given
        val input = mapOf(
            -50 to -49,
            -1 to 0,
            0 to 1,
            30 to 31,
            49 to 50,
            50 to 50,
            51 to 51,
            70 to 70,
        )
        input.forEach {
            //when
            val item = Item("", 0, it.key)
            item.increaseQuality()
            //then
            assertEquals(it.value, item.quality)
        }
    }
}
