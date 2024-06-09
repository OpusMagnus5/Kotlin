package org.example

fun main() {
    val result = try { //Mozna zapisywac rezultat z try catch jako wynik
        Math.divideExact(10, 0)
    } catch (e: Exception) {
        -1
    }
}

fun makeAnException(): Nothing { //kiedy funkcja rzuca wyjątek zwraca typ Nothing
    throw Exception("I'm an exception!")
}