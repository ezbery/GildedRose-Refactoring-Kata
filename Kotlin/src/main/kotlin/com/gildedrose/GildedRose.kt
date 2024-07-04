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
        if (item.quality < 50)
            item.quality += 1
        item.sellIn -= 1
        if (item.sellIn < 0 && item.quality < 50)
            item.quality += 1
    }

    fun backstageUpdate(item: Item) {
        if (item.quality < 50)
            item.quality += 1
        if (item.sellIn < 11 && item.quality < 50)
            item.quality += 1
        if (item.sellIn < 6 && item.quality < 50)
            item.quality = item.quality + 1
        item.sellIn -= 1
        if (item.sellIn < 0)
            item.quality = 0
    }

    fun sulfurasUpdate(item: Item) {}

    fun standardUpdate(item: Item) {
        if (item.quality > 0)
            item.quality -= 1
        item.sellIn -= 1
        if (item.sellIn < 0 && item.quality > 0)
            item.quality -= 1
    }
}
