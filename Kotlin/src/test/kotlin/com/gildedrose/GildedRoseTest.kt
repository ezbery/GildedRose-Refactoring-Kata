package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    val MIN_VALUE = -1000
    val MAX_VALUE = 1000

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
        (-MIN_VALUE..MAX_VALUE).forEach {
            //when
            val item = Item("", 0, it)
            item.decreaseQuality()
            //then
            if (it > 0)
                assertTrue(item.quality == it - 1)
            else
                assertTrue(item.quality == it)
        }
    }

    @Test
    fun `increase quality tests`() {
        //given
        (-MIN_VALUE..MAX_VALUE).forEach {
            //when
            val item = Item("", 0, it)
            item.increaseQuality()
            //then
            if (it < 50)
                assertTrue(item.quality == it + 1)
            else
                assertTrue(item.quality == it)
        }
    }
}
