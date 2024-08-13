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

    /*
    * StringBuilder reprezentujący zmienny ciąg znaków. Może być używany do wydajnego wykonywania wielu operacji
    * manipulacji ciągami znaków, umożliwiając modyfikowanie jego zawartości bez tworzenia nowego obiektu.
    * Klasa StringBuilder ma dwóch ważnych członków: length i capacity(). Właściwość length reprezentuje liczbę znaków zawartych w obiekcie StringBuilder,
    * podczas gdy metoda capacity zwraca liczbę znaków, które obiekt może pomieścić, zanim konieczna będzie zmiana jego rozmiaru
    */

    val sb = StringBuilder() // z domyślną pojemnością początkową
    val sb2 = StringBuilder(100) // określa początkową pojemność StringBuilder, przekazując konstruktorowi wartość całkowitą
    val sb3 = StringBuilder("Kotlin")
    val sb4 = StringBuilder(sb)
    val str2 = buildString {
        append("Hello") // umożliwia dodawanie znaków lub ciągów znaków na końcu konstruktora StringBuilder
        insert(5, ",") // umożliwia wstawianie znaków lub ciągów znaków w określonej pozycji w konstruktorze StringBuilder
        delete(5, 7) // metoda delete: umożliwia usuwanie znaków lub ciągów znaków z określonego zakresu w konstruktorze StringBuilder
        replace(10, 13, "three") // Metoda replace: umożliwia zastępowanie znaków lub ciągów znaków w określonym zakresie w konstruktorze StringBuilder.
        reverse() // Metoda reverse: umożliwia odwrócenie znaków w konstruktorze StringBuilder
        append(2.0)
    }
    val str3 = buildString(100) {
    }
    sb.setLength(0) // resetuje stan buildera
    sb.toString() // zwraca stringa
}