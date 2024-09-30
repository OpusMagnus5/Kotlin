package org.example

import java.util.*

fun example11() {

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

    stuff.forEach { print("$it ") }

    // Jednego iteratora można użyć tylko raz na iterację
    val songsIterator = stuff.iterator()
    while (songsIterator.hasNext()) {
        print("${songsIterator.next()} ")
    }

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

    // Mapowanie mapy na liste wartości lub kluczy
    val strings: List<String> = students.map { it.key.uppercase() }
    val ints: List<Int> = students.map { it.value * 2 }

    // Mapowanie tylko kluczy lub wartości zachowując strukture mapy
    val mapKeys: Map<String, Int> = students.mapKeys { it.key.uppercase() }
    val mapValues: Map<String, Int> = students.mapValues { it.value * 2 }

    val listOfMaps = listOf(
        mapOf(1 to "one", 2 to "two"),
        mapOf(3 to "three", 4 to "four")
    )

    val flatMap1: Map<Int, String> = listOfMaps.flatMap { it.entries }.associate { it.key to it.value } // mapowanie listy map na mape

    val visitors = setOf<String>("Vlad", "Vanya", "Liza", "Liza") //inicjalizacja setów
    val set = buildSet<String> {
        add("a")
        addAll(visitors)
        add("d")
    }

    visitors - set //dodawanie i odejmowanie setów
    visitors + set

    /*
    * Predicates in collections
    */
    visitors.none() // zwraca true jesli kolekcja jest niepusta
    visitors.any { x -> x.startsWith("a") }
    visitors.none { x -> x.startsWith("a") }
    visitors.all { x -> x.startsWith("a") }

    /*
    * Sorting collections
    */
    stuff.sorted()
    stuff.sortedDescending()
    /*
    * Zwraca kopię oryginalnej kolekcji w odwrotnej kolejności indeksów.
    * Jeśli zmienisz oryginalną kolekcję, zmiany nie wpłyną na kopię.
    */
    stuff.reversed()
    /*
    * Metoda asReversed() zwraca odniesienie do oryginalnej kolekcji w odwrotnej kolejności indeksów.
    * Jest to lżejsze, ponieważ nie tworzy nowej kopii, ale jeśli oryginalna kolekcja ulegnie zmianie,
    * zmiany zostaną odzwierciedlone na odwróconej liście. Musimy być ostrożni, jeśli pracujemy z mutowalnymi kolekcjami.
    */
    stuff.asReversed()
    /*
    * Daje nową kolekcję, w której oryginalne elementy są losowo tasowane.
    * Można jej użyć bez argumentów lub z instancją Random jako źródłem losowości.
    * Użycie liczby całkowitej jako ziarna w generatorze Random spowoduje przetasowanie elementów w losowy sposób,
    * który można odtworzyć, jeśli nadal będziesz używać tego samego ziarna.
    */
    stuff.shuffled()
    stuff.shuffled(Random(1))

    // Retrieve single element
    stuff.elementAt(0)
    stuff.get(0)
    stuff[0]
    stuff.first()
    stuff.last()
    stuff.elementAtOrElse(0) { 1 }
    stuff.getOrElse(1) { 2 }
    stuff.find { it > 1 }
    stuff.findLast { it > 2 }

    // Mapuje obiekt i zwraca
    stuff.firstNotNullOf { it.toString() }
    stuff.firstNotNullOfOrNull { it.toString() }

    stuff.random()
    stuff.randomOrNull()

    stuff.map { it * 2 }
    stuff.mapIndexed{ index, value -> value * index }
    // Jeśli zastosujesz funkcję transformacji do elementów, a transformacja nie może zostać wykonana na niektórych z nich, wynikiem dla tych elementów jest null
    // Można uniknąć tych wyników używając mapNotNull() lub mapIndexedNotNull()
    stuff.mapNotNull { it * 2 }
    stuff.mapIndexedNotNull{ index, value -> value * index }

    val nestedNumbers = listOf(
        listOf(1, 2, 3),
        listOf(4, 5, 6),
        listOf(7, 8, 9)
    )
    val flatten: List<Int> = nestedNumbers.flatten() // łączy listy w jedną
    val flatMap = nestedNumbers.flatMap { it.map { it * 2 } } // łączy listy w jedną i jednocześnie mapuje

}

fun helpingTheRobot(purchases: Map<String, Int>, addition: Map<String, Int>) : MutableMap<String, Int> {
    return (purchases.keys + addition.keys)
        .associateWith { key -> purchases.getOrDefault(key, 0) + addition.getOrDefault(key, 0) }
        .toMutableMap()
}