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

//Zagnieżdżone klasy - Nested Class, brak dostępu do pól klasy rodzica
class Superhero {
    val power = 1000

    class MagicCloak {
        val magicPower = 100
    }

    class Hammer {
        // you cannot access power property from Superhero here
        val mightPower = 100
    }
}

// Inner class, może mieć dostęp do pól klasy rodzica w przeciwieńswtie do klasy nested
class Cat(val name: String, val color: String) {
    inner class Bow(val color: String) {
        fun printColor() {
            // this@Cat.color takiej notacji użwyamy zeby wskazać dokładnie której klasy pole gdy mają takie same
            println("The cat named $name is ${this@Cat.color} and has a $color bow.")
        }
    }
}

/*
* Overriding constructors
* Podczas deklarowania podklasy możemy użyć słów kluczowych open, final i override, aby kontrolować dziedziczenie i polimorfizm.
* open: pozwala podklasom dziedziczyć lub nadpisywać funkcje i właściwości.
* final: zapobiega nadpisywaniu funkcji lub właściwości przez podklasy.
* override: jest używany przez podklasę do nadpisywania funkcji lub właściwości nadklasy
*/

open class Person4(open val name: String)

class Employee(override val name: String, val id: Int) : Person4(name)  // Nadpisujemy pole name








