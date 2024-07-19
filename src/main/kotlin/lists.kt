package org.example

fun main () {
    val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
    println(southernCross.joinToString()) //  Acrux, Gacrux, Imai, Mimosa

    val stars = mutableListOf("Ginan", "Mu Crucis")
    val newList = southernCross + stars //listy można łączyć dodając
    val bo = southernCross == stars // można listy porównywac ich kontent i rozmiar
    stars += "Damian" //można dodawać elementy w taki sposób

    val toMutableList = newList.toMutableList() //tworzy kopie listy
    mutableListOf(2, 3, 5)
}