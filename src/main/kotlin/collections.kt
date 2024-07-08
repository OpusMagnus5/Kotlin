package org.example

fun main() {

    val stuff = listOf(1)
    stuff.contains(1)
    1 in stuff // to samo co contains, preferowane jest to użycie

    listOf(2) //immutable List
    mutableListOf(2) //mutable List
    buildSet<Int> { //builder List
        add(1)
        addAll(stuff)
    }
    for (element in stuff) { //iterowanie
        println(element)
    }
}