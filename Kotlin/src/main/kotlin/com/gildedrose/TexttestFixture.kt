package com.gildedrose

fun main(args: Array<String>) {

    println(Constants.HEADER)

    val items = listOf(
        Item("+5 Dexterity Vest", 10, 20), //
        Item("Aged Brie", 2, 0), //
        Item("Elixir of the Mongoose", 5, 7), //
        Item("Sulfuras, Hand of Ragnaros", 0, 80), //
        Item("Sulfuras, Hand of Ragnaros", -1, 80),
        Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
        Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
        Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
        // this conjured item does not work properly yet
        Item("Conjured Mana Cake", 3, 6)
    )

    val app = GildedRose(items)

    val days =
        if (args.isNotEmpty()) Integer.parseInt(args[0]) + 1
        else Constants.DEFAULT_DAYS


    val output = (0..<days).map { day ->
        dayToString(day, items).also {
            app.update()
        }
    }

    println(output.allDaysToString())
}

fun daySummary(day: Int, items: List<Item>) =
    listOf(
        "-------- day $day --------",
        "name, sellIn, quality",
        items.joinToString("\n") { it.toString() },
        ""
    )

fun dayToString(day: Int, items: List<Item>) = daySummary(day, items).joinToString("\n")
fun List<String>.allDaysToString() = this.joinToString("\n") + "\n"
