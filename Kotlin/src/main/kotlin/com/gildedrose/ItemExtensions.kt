package com.gildedrose


fun Item.increaseQuality(n: Int = 1) {
    if (quality < 50)
        quality += n
}

fun Item.decreaseQuality(n: Int = 1) {
    if (quality > 0)
        quality -= n
}

fun Item.increaseQualityIfSellInLowerThan(sellInThreshold: Int, n: Int = 1) {
    if (sellIn < sellInThreshold)
        increaseQuality(n)
}

fun Item.decreaseQualityIfSellInLowerThan(sellInThreshold: Int, n: Int = 1) {
    if (sellIn < sellInThreshold)
        decreaseQuality(n)
}