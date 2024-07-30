package org.example

fun example() {
    repeat(3) { // najprostrza pętla powtarzająca blok kodu określoną ilośc razy
        println("Hello")
    }

    repeat(3) { index ->
        println("Hello with index $index")
        println()
    }

    do { //while i do while tak samo jak w JAVA
    } while (false)

    while (false) {
    }

    val stuff = emptyArray<Int>()

    for (element in stuff) { //iterowanie
        println(element)
    }

    for (element in 1..4 step 2) // co drugi element tylko z range
        println(element)

    for (element in stuff.indices) {} //iterowanie ale po indexach

    for (index in stuff.indices.reversed()) {} //iterowanie w odrotnej kolejności

    for (i in 0..stuff.lastIndex) {}

    for (i in stuff.lastIndex downTo 0) {}
}