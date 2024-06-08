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
        2 -> println("Two")
        3 -> println("Three")
        4 -> println("Four")
        else -> println("Number is greater than four")
    }

    val message = when (number) { // możliwe jest zwracanie wartości
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        else -> "Number is greater than four"
    }

    when { // można też użwać warunków zamiast stałych wartościF
        number < 0 -> println("Negative number")
        number in 1..10 -> println("Number between 1 and 10")
        number % 2 == 0 -> println("Even number")
        else -> println("Odd number greater than 10")
    }
}

fun greet(name: String, greeting: String = "Hello"): String { //deklaracja funkcji, można przypisywac wartości domyślne gdy trafi null
    return "$greeting, $name!"
}

fun multiplyNumbers(a: Int, b: Int): Int = a * b // skrócony zapis dla funkcji z pojedyńa operacją, można w tym przypadku równiez pominąć typ zwracany

// Kiedy funkcja nie zwraca nic, zwraca typ Unit podobnie jak Void w Java