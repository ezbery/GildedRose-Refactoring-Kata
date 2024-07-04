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
        val app = GildedRose(TestData.items)
        val actual = mutableListOf(Constants.HEADER)
        //when
        for (i in 0..<Constants.DEFAULT_DAYS) {
            actual.add(dayToString(i, app.items))
            app.update()
        }
        //then
        assertEquals(TestData.expectedOutput, actual.allDaysToString())
    }
}
