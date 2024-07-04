package com.gildedrose

import com.gildedrose.Constants.AGED_BRIE
import com.gildedrose.Constants.BACKSTAGE_PASSES
import com.gildedrose.Constants.SULFURAS

class GildedRose(var items: List<Item>) {

    fun update() {
        items.map { updateItem(it) }
    }

    fun updateItem(item: Item) {
        when (item.name) {
            AGED_BRIE -> agedBrieUpdate(item)
            BACKSTAGE_PASSES -> backstageUpdate(item)
            SULFURAS -> sulfurasUpdate(item)
            else -> standardUpdate(item)
        }
    }

    fun agedBrieUpdate(item: Item) {
        item.quality = increaseQuality(item.quality)
        item.sellIn -= 1
        if (item.sellIn < 0)
            item.quality = increaseQuality(item.quality)
    }

    fun backstageUpdate(item: Item) {
        item.quality = increaseQuality(item.quality)
        if (item.sellIn < 11)
            item.quality = increaseQuality(item.quality)
        if (item.sellIn < 6)
            item.quality = increaseQuality(item.quality)
        item.sellIn -= 1
        if (item.sellIn < 0)
            item.quality = 0
    }

    fun sulfurasUpdate(item: Item) {}

    fun standardUpdate(item: Item) {
        item.quality = decreaseQuality(item.quality)
        item.sellIn -= 1
        if (item.sellIn < 0)
            item.quality = decreaseQuality(item.quality)
    }

    fun increaseQuality(quality: Int) =
        if (quality < 50)
            quality + 1
        else
            quality

    fun decreaseQuality(quality: Int) =
        if (quality > 0)
            quality - 1
        else
            quality
}
