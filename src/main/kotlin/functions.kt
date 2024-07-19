package org.example

import java.util.Scanner

fun main() {
    // Kiedy funkcja nie zwraca nic, zwraca typ Unit podobnie jak Void w Java

    readln() //czyta linie
    val scanner = Scanner(System.`in`) //możemy sięgać do bibliotek javy normalnie
    Scanner("sdsds") // możemy wskazać źródło sami
    scanner.useDelimiter("_") // mozemy ustawiac wlasny delimiter
    scanner.hasNext() // sprawdza czy są dane do odczytu

    val (a, b, c, d) = readln().split(",") //wczytanie i rozdzielenie inputów, uwtorzenie 4 zmiennnych

    greet(name = "Damian", greeting = "Hi") //można stricte określac nazwe zmiennej i wartośc, nie trzeba wtedy podawac w kolejności deklaracji

    val max = if (a > b) { //if może zwracac wartośc, zwracane jest ostatnie wyrażenie czyli np a lub b
        println("Choose a")
        a
    } else {
        println("Choose b")
        b
    }

    val max2 = if (a > b) a else b // skrócony zapis jeśli to sa pojedyncze wyrażenia

    val number = 5

    when (number) { // jak switch w java, nie trzeba breaka
        1 -> println("One")
        in 1..10 -> println("Two") //można używac range
        1 + 2 -> println("Three") // można robić działania
        4, 5 -> println("Four") // można podawac kilka opcji po przecinku
        else -> println("Number is greater than four")
    }

    val message = when (number) { // możliwe jest zwracanie wartości
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        else -> "Number is greater than four"
    }

    when { // można też użwać warunków zamiast stałych wartości, jesli nie podamy przy zmiennej możemy wykorzystać do porównania wczesniej zadeklarowana
        number < 0 -> println("Negative number")
        number in 1..10 -> println("Number between 1 and 10")
        number % 2 == 0 -> println("Even number")
        else -> println("Odd number greater than 10")
    }

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

fun greet(name: String, greeting: String = "Hello"): String { //deklaracja funkcji, można przypisywac wartości domyślne gdy trafi null
    return "$greeting, $name!"
}

fun multiplyNumbers(a: Int, b: Int): Int = a * b // skrócony zapis dla funkcji z pojedyńa operacją, można w tym przypadku równiez pominąć typ zwracany

// Kiedy funkcja nie zwraca nic, zwraca typ Unit podobnie jak Void w Java