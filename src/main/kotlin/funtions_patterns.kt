package org.example

fun main() {

    //Functoinal patterns

    //Monads
    val result: Result<Int> = Result.runCatching { someRiskyOperation() } //coś ala optional, może przechowywać wynik lub exception
    result.map { value -> doSomethingWith(value) }

}

//Tail Recursion
tailrec fun factorial(n: Int, acc: Int = 1): Int { //wywołanie rekurencyjne samej siebie, tailrec optymalizuje wywołanie i call stack
    return if (n == 1) acc else factorial(n - 1, n * acc)
}

fun someRiskyOperation(): Int {
    return 1
}

fun doSomethingWith(value: Int) {
}
