package org.example

//klasy definiujemy jak w Java
class Clazz {
    var name: String = "Unknown" //uzywamy var albo val, val jest final po inicjalizacji
    val age: Int = 0 // zawsze musimy zaincjalizowac zmienną
}

fun main() {
    val clazz = Clazz() // inicjalizacja klasy
}