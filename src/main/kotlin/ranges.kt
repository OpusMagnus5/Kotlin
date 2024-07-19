package org.example

val ageValidForJob = 18..59

fun main() {

    var a: Int = 3;
    var b: Int = 2;
    var c: Int = 1
    val within = c in a..b // sprawdzenie czy czy c jest w zakresie od a do b inclusive
    val within2 = c in a..<b // to samo tylko exclusive b
    val notWithin = c !in a..<b // zaprzeczenie
    val range = 100 .. 200 // przypisanie Range do zmiennej
    val charRange = 'a'..'z' //Range dla char
    4 downTo 1 // range od tyłu
    1 until 4 //range to samo co z -1
}