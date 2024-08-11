package org.example

fun example14() {
    val (a, b, c, d) = readln().split(",")

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
}