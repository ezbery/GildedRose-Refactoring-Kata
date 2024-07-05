package com.gildedrose

import com.gildedrose.Constants.AGED_BRIE
import com.gildedrose.Constants.BACKSTAGE_PASSES
import com.gildedrose.Constants.CONJURED
import com.gildedrose.Constants.SULFURAS
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class GildedRoseTest {
    val MIN_VALUE = -1000
    val MAX_VALUE = 1000

    @Test
    fun `standard update test`() {
        //given
        val inputSellIn = 5
        val inputQuality = 5
        val item = Item("standard", inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality - 1, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `standard update test with sellIn lower than 0`() {
        //given
        val inputSellIn = 0
        val inputQuality = 5
        val item = Item("standard", inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality - 2, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `backstage ticket update test`() {
        //given
        val inputSellIn = 15
        val inputQuality = 5
        val item = Item(BACKSTAGE_PASSES, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality + 1, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `backstage ticket update test when 10 days to event`() {
        //given
        val inputSellIn = 10
        val inputQuality = 5
        val item = Item(BACKSTAGE_PASSES, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality + 2, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `backstage ticket update test when 5 days to event`() {
        //given
        val inputSellIn = 5
        val inputQuality = 5
        val item = Item(BACKSTAGE_PASSES, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality + 3, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `backstage ticket update test when after event`() {
        //given
        val inputSellIn = 0
        val inputQuality = 5
        val item = Item(BACKSTAGE_PASSES, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(0, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `sulfuras update test`() {
        //given
        val inputSellIn = 5
        val inputQuality = 5
        val item = Item(SULFURAS, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `aged brie update test`() {
        //given
        val inputSellIn = 5
        val inputQuality = 5
        val item = Item(AGED_BRIE, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality + 1, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `aged brie update test when sellIn lower than 0`() {
        //given
        val inputSellIn = 0
        val inputQuality = 5
        val item = Item(AGED_BRIE, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality + 2, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `conjured update test`() {
        //given
        val inputSellIn = 5
        val inputQuality = 5
        val item = Item(CONJURED, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality - 2, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    fun `conjured update test when sellIn lower than 0`() {
        //given
        val inputSellIn = 0
        val inputQuality = 5
        val item = Item(CONJURED, inputSellIn, inputQuality)
        val app = GildedRose(listOf(item))

        assertEquals(item.name, app.items.first().name, "before: ${app.items.first()}")
        assertEquals(inputSellIn, app.items.first().sellIn, "before: ${app.items.first()}")
        assertEquals(inputQuality, app.items.first().quality, "before: ${app.items.first()}")
        //when
        app.updateQuality()
        //then
        assertEquals(item.name, app.items.first().name, "after: ${app.items.first()}")
        assertEquals(inputSellIn - 1, app.items.first().sellIn, "after: ${app.items.first()}")
        assertEquals(inputQuality - 4, app.items.first().quality, "after: ${app.items.first()}")
    }

    @Test
    @Disabled
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
    @Disabled
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
