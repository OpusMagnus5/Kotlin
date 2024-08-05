package org.example

fun main() {

    val greeting = "Hello"
    val str = "str"

    val letter = greeting[0] //dostęp do pojedynczego znaku przez tablice
    greeting.first() //pierwszy znak
    greeting.last() //ostatni znak
    greeting.lastIndex //oststni index

    val same = greeting == str // porównujemy przez == to jak equals w java

    greeting.substring(0, 3)
    greeting.substringAfter('l')
    greeting.substringAfterLast('l')

    greeting.replace("morning", "bye")
    greeting.replaceFirst("morning", "bye")

    greeting.lowercase()
    greeting.uppercase()
}