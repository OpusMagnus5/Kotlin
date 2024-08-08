package org.example

enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet");

    fun printFullInfo() {
        println("Color - $color")
    }
}

fun example13() {
    Rainbow.RED.name // Zwraca RED, nazwe enuma
    Rainbow.ORANGE.ordinal // Zwraca 2, liczbę porządkową
    Rainbow.entries // zwraca liste dostępnych wartosci enuma
    Rainbow.valueOf("RED") // Zwraca instancje enuma na podstawie nazwy
}