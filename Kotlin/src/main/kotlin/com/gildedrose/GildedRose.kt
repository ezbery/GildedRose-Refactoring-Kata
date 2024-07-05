package com.gildedrose

import com.gildedrose.Constants.AGED_BRIE
import com.gildedrose.Constants.BACKSTAGE_PASSES
import com.gildedrose.Constants.CONJURED
import com.gildedrose.Constants.SULFURAS

class GildedRose(var items: List<Item>) {

    fun updateQuality() {
        items.map { updateItem(it) }
    }

    private fun updateItem(item: Item) {
        when {
            item.name.contains(AGED_BRIE) -> agedBrieUpdate(item)
            item.name.contains(BACKSTAGE_PASSES) -> backstageUpdate(item)
            item.name.contains(SULFURAS) -> sulfurasUpdate(item)
            item.name.contains(CONJURED) -> conjuredUpdate(item)
            else -> standardUpdate(item)
        }
    }

    private fun agedBrieUpdate(item: Item) {
        item.increaseQuality()
        item.sellIn -= 1
        item.increaseQualityIfSellInLowerThan(0)
    }

    private fun backstageUpdate(item: Item) {
        item.increaseQuality()
        item.increaseQualityIfSellInLowerThan(11)
        item.increaseQualityIfSellInLowerThan(6)
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0, item.quality)
    }

    private fun sulfurasUpdate(item: Item) {}

    private fun conjuredUpdate(item: Item) {
        item.decreaseQuality()
        item.decreaseQuality()
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0)
        item.decreaseQualityIfSellInLowerThan(0)
    }

    private fun standardUpdate(item: Item) {
        item.decreaseQuality()
        item.sellIn -= 1
        item.decreaseQualityIfSellInLowerThan(0)
    }
}
