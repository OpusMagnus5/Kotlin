package org.example

import java.io.FileReader

fun main() {
    val result = try { //Mozna zapisywac rezultat z try catch jako wynik
        Math.divideExact(10, 0)
    } catch (e: Exception) {
        -1
    }

    FileReader("file.txt").use { // use działa jak try witch resources
            reader ->
    }
}

fun makeAnException(): Nothing { //kiedy funkcja rzuca wyjątek zwraca typ Nothing
    throw Exception("I'm an exception!")
}

class LessThanZero: Exception("Parameter less than zero") // deklaracja nowego wyjątku

class MyCustomException: Exception {
    constructor() : super()  // super możemy użyć tylko wtedy jeśli nowa klasa nie ma primary constructora
    constructor(message: String?) : super(message)
    constructor(message: String?, cause: Throwable?) : super(message, cause)
    constructor(cause: Throwable?) : super(cause)
}