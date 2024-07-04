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
        item.increaseQuality()
        item.sellIn -= 1
        item.increaseQualityIfSellInLowerThan(0)
    }

    fun backstageUpdate(item: Item) {
        item.increaseQuality()
        item.increaseQualityIfSellInLowerThan(11)
        item.increaseQualityIfSellInLowerThan(6)
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0, item.quality)
    }

    fun sulfurasUpdate(item: Item) {}

    fun standardUpdate(item: Item) {
        item.decreaseQuality()
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0)
    }
}
