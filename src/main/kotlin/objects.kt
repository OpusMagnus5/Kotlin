package org.example

fun main() {
    String() == String() // == porównuje stan obiektu
    String() === String() // === porównuje referencje obiektów

    /*
    * Rzutowanie
    * operator is lub !is - Gdy typ nullable jest sprawdzany za pomocą operatora is,
    * Kotlin automatycznie rzutuje obiekt na typ non-nullable.
    */
    val obj: Any = "Hello, Kotlin" // Typ Any może być każdego typu

    if (obj is String) {
        println(obj.uppercase()) // nie musimy castować po sprawdzeniu typu
    } else {
        println("obj is not a String")
    }

    when (obj) {
        is String -> println()
        is Int -> println()
        else   -> println()
    }

    val str: String = obj as String // Unsafe cast operator, the as operator throws a ClassCastException

    /*
    * Operator as? służy do rzutowania obiektu na typ nullable.
    * Jeśli obiekt nie może zostać rzutowany na określony typ, operator as? zwraca wartość null.
    */
    val str2: String? = obj as? String
}