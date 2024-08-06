package org.example

fun example10() {

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

    greeting.split(" ")

    for (i in 0 until greeting.length) {
        greeting[i]
    }

    for (index in greeting.indices){
        greeting[index]
    }

    for (ch in greeting) {
        Character.isWhitespace(ch)
    }

    val charArray: CharArray = greeting.toCharArray()
    val arraysString = String(charArray)

}