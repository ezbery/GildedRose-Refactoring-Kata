package com.gildedrose

import com.gildedrose.Constants.AGED_BRIE
import com.gildedrose.Constants.BACKSTAGE_PASSES
import com.gildedrose.Constants.CONJURED
import com.gildedrose.Constants.SULFURAS

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.map { updateItem(it) }
    }

    fun updateItem(item: Item) {
        when {
            item.name.contains(AGED_BRIE) -> agedBrieUpdate(item)
            item.name.contains(BACKSTAGE_PASSES) -> backstageUpdate(item)
            item.name.contains(SULFURAS) -> sulfurasUpdate(item)
            item.name.contains(CONJURED) -> conjuredUpdate(item)
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

    fun conjuredUpdate(item: Item) {
        item.decreaseQuality()
        item.decreaseQuality()
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0, 2)
    }

    fun standardUpdate(item: Item) {
        item.decreaseQuality()
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0)
    }
}
