package org.example

//klasy definiujemy jak w Java
class Clazz {
    var name: String = "Unknown" //uzywamy var albo val, val jest final po inicjalizacji
    val age: Int = 0 // zawsze musimy zaincjalizowac zmienną
}

fun main() {
    val clazz = Clazz() // inicjalizacja klasy
}

class Person(val name: String, var age: Int) { //Primary konstruktor
    init { //kod inicjalizujący wywoluje się po konstuktorze, można miec kilka takich bloków i wolują się w kolejnosci napisania
        println("Helo Person")
    }

    //w takm przypadku najpierw jest wołany primary constructor, nastepnie blok init, inicjalizacja wartości i na koncu secondary constructor
    constructor(name: String) : this(name, 0) { //secondary konstruktor musi wywołac primary jeśli istnieje
        println("Secondary constructor called")
    }
}

class Person2 {

    val name: String
    var age: Int
    constructor(name: String, age: Int) { //secondary konstruktor
        this.name = name
        this.age = age
    }
}

// w Kotlin możemy dopisywać metody które posiada obiekt ale tak zdefiniowane metody nie mają dostępu do prywatnych pól??
// nie można nadpisywac metod które posiada już obiekt
fun String.repeated(): String = this + this