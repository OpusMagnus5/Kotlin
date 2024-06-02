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
}