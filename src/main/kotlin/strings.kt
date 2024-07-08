package org.example

fun main() {

    val greeting = "Hello"
    val str = "str"

    val letter = greeting[0] //dostęp do pojedynczego znaku przez tablice
    greeting.first() //pierwszy znak
    greeting.last() //ostatni znak
    greeting.lastIndex //oststni index

    val same = greeting == str // porównujemy przez == to jak equals w java
}