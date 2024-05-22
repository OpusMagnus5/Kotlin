package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

const val STATE: String = "Full"
// const val dla stałych zmiennych które są znane już w trakcie kompilacji
// const może być stosowanych tylko dla prymitywów
// musi być deklarowana poza funkcją, na najwyższym poziomie

fun main() {
    val numberType: Int = 1_000_000 // tak można definiować liczby w celu czytelności
    // val deklaruje tylko zmienną do oczytu (referencje)

    var mutableType: String = "Kotlin";
    // var deklaruje zmienną którą można modyfikować

    // przypisując zmienne val do var możemy zmieniać zmienną var
    var toChangeVal: Int = numberType;
    toChangeVal = 1_111;

    println(numberType); //drukuje do konsoli
}