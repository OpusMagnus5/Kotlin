package org.example

fun example9() {
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

    // ITERATOR
    var iterator = stuff.iterator()
    while (iterator.hasNext()) {}
    iterator.forEach {}

    // Jeśli iterator jest z kolekcji mutable możemy usuwac jej elementy
    val food = mutableSetOf("donuts", "cakes", "tarts")
    val mutableIterator = food.iterator()
    mutableIterator.remove()

    // Listy mają specjalny operator ListIterator który pozwala na iterowanie w przód i tył
    val strings = listOf("i", "like", "donuts")
    val listIterator = strings.listIterator()
    while (listIterator.hasPrevious()) {
        listIterator.previous()
        listIterator.previousIndex()
    }

    // Mutable listy mają swoją wersje ListIteratora
    val words = mutableListOf("i", "know", "Claire")
    val mutableListIterator = words.listIterator()
    mutableListIterator.next()
    mutableListIterator.set("don't know")
    mutableListIterator.add("John")
}