package org.example

import java.util.Scanner

fun main() {
    readln() //czyta linie
    val scanner = Scanner(System.`in`) //możemy sięgać do bibliotek javy normalnie
    Scanner("sdsds") // możemy wskazać źródło sami
    scanner.useDelimiter("_") // mozemy ustawiac wlasny delimiter
    scanner.hasNext() // sprawdza czy są dane do odczytu

    val (a, b, c, d) = readln().split(",") //wczytanie i rozdzielenie inputów, uwtorzenie 4 zmiennnych

    val greet: (String) -> Unit = { name -> println("Hello, $name!") } // można zapisywac funkcje jako zmienną
    val sum = operateOnNumbers(2, 3, { x, y -> x + y }) //przekazywanie metody jako parametr
    val sumFunction = getMathFunction("sum") //można zwracac funkcje
    //wykorzystanie
/*    Int.setOnClickListener { view -> // lambda
    }

    fun fetchData(callback: (data: Data) -> Unit) { //callback
        callback(result)
    }
    fetchData { data ->
        println("Data received: $data")
    }*/

    val numbers = listOf(1, 2, 3, 4)
    val evenNumbers = numbers.filter { it % 2 == 0 } //lambda
    val fun1 = { a1: Int, b1: Int -> a1 * b1 }
    val mul1 = fun(a: Int, b: Int): Int { // to jest to samo co wyzej
        return a * b
    }
    val fun2 = { println() } //lambda bez argumentów

    listOf(1, 2, 3, 4).forEach { // gdyby było samo return wychodzimy do main()
        if (it == 3) return@forEach  // pomijamy interacje w przypadku 3 po małpie piszemy nazwe funkcji która woła lambde
        println(it)
    }

    //originalText.filter() { c -> c != '.' } taki zapis gdy przekazujemy lambde jako ostatni argument (poza nawiasami ())
    //originalText.filter { c -> c != '.' } jesli nawiasy są puste i lambda jest jedynym parametrem mozemy pominąc ()
    //originalText.filter { it != '.' } // w lamdach jest dostępny parametr it który wskazuje parametr przekazany do lamdy

    fun topFun() {
        println("Hello from topFun!")
    }

    val functionRef = ::topFun //refrencja do funkcji jak JAVA
    ::String //referencja do konstruktora
}

fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
    return operation(a, b)
}

fun getMathFunction(type: String): (Int, Int) -> Int {
    return when (type) {
        "sum" -> { x, y -> x + y }
        "subtract" -> { x, y -> x - y }
        else -> { _, _ -> 0 }
    }
}

fun multiplyNumbers(a: Int, b: Int): Int = a * b // skrócony zapis dla funkcji z pojedyńa operacją, można w tym przypadku równiez pominąć typ zwracany

// Kiedy funkcja nie zwraca nic, zwraca typ Unit podobnie jak Void w Java