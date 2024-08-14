package org.example

import java.util.Scanner

fun example15() {
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

    /*
    * Infix function notation
    * W notacji infiksowej nazwa funkcji jest umieszczana między argumentami, a sama nazwa funkcji jest operatorem.
    * Przykładem takiej funkcji może być add(2, 4), w której funkcja add oznacza dodawanie ("add"): add(2, 4) = 2 add 4
    *
    * To define an infix function, you must meet the following requirements.
    * They must be member functions or extension functions.
    * They must have a single parameter.
    * The parameter must not accept variable number of arguments and must have no default value.
    */

    println(1 add 2)

    /*
    * Lambda with receiver
    */

    sum(1, 2)
    1.sum2(2) // różnica w wywołaniu, można wywoływac na konkretnym obiekcie
    val str2 = myString { // słuzy tez do inicjowania obiektów, tak działa podspodem np StringBuilder
        append("Hello, ".uppercase())
        append("World!")
    }
}

val sum: (Int, Int) -> Int = { a, b -> a + b } // zwykła lambda
val sum2: Int.(Int) -> Int = { a -> this + a } // lambda with receiver type Int.(Int) Int. wskazuje receivera
fun myString(init: StringBuilder.() -> Unit): String { // StringBuilder. wskazuje receivera a () to po prostu lamda bez argumentów
    init(StringBuilder()) // to jest drugi sposób wywołania lambdy przekazując obiekt jako parametr mimo że lambda w zapisie nie przyjmuje zadnych parametrów
    return StringBuilder().apply(init).toString()
}

infix fun Int.add(x: Int): Int = this + x

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