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

    for (element in 1..4 step 2) // co drugi element tylko z range
        println(element)

    for (element in stuff.indices) {} //iterowanie ale po indexach

    for (index in stuff.indices.reversed()) {} //iterowanie w odrotnej kolejności

    val students = mapOf( //tworzenie mapy
        "Zhenya" to 5,
        "Vlad" to 4,
        "Nina" to 5
    )

    val values = mapOf<String, Int>("Second" to 2, "Third" to 3)
    val map = buildMap<String, Int> { //inny sposób na inicjalizacje mapy
        put("First", 1)
        putAll(values)
        put("Fourth", 4)
    }

    val grade = students["Nina"] //dostęp do wartości pod kluczem
    val (name, grade1) = Pair("Zhenya", 5) //Pair jest typem dla entry w Mapie
    val p = Pair(2, 3)
    p.first // dostep do klucza
    p.second // dostep do wartosci
    val (name2, grade3) = "Vlad" to 4 // to samo co Pair

    students.containsKey("")
    students.containsValue(1) //sprawdzanie posiadania klucza i wartości

    for ((key, value) in students) {} //iteracja
    for (st in students){} // durgi sposób

    val groupOfStudents = mutableMapOf<String, Int>()
    groupOfStudents.putIfAbsent("", 1) // dodaje gdy nie ma klucza
    groupOfStudents += "S" to 1 // można również dodawać nowe elementy w ten sposób


    val visitors = setOf<String>("Vlad", "Vanya", "Liza", "Liza") //inicjalizacja setów
    val set = buildSet<String> {
        add("a")
        addAll(visitors)
        add("d")
    }

    visitors - set //dodawanie i odejmowanie setów
    visitors + set
}

fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) : MutableMap<String, Int> {
    return (purchases.keys + addition.keys)
        .associateWith { key -> purchases.getOrDefault(key, 0) + addition.getOrDefault(key, 0) }
        .toMutableMap()
}