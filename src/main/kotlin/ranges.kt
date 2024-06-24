package org.example

const val ageValidForJob = 18..59

fun main() {

    var a: Int;
    var b: Int;
    var c: Int;
    val within = c in a..b // sprawdzenie czy czy c jest w zakresie od a do b inclusive
    val within2 = c in a..<b // to samo tylko exclusive b
    val notWithin = c !in a..<b // zaprzeczenie
    val range = 100 .. 200 // przypisanie Range do zmiennej
    val charRange = 'a'..'z' //Range dla char
}