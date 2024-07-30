package org.example

/*
* Po utworzeniu tablicy nie można jej zmienić. Zapisane elementy można jednak modyfikować w dowolnym momencie.
* Pierwszy element ma zawsze indeks 0, ostatni element ma indeks równy rozmiarowi tablicy - 1
* Kotlin może obsługiwać wiele typów tablic: IntArray, LongArray, DoubleArray, FloatArray, CharArray, ShortArray, ByteArray, BooleanArray
*/

fun example() {
    // Aby stworzyć nową tablicę wywołujemy metodę np - intArrayOf
    val numbers = intArrayOf(1, 2, 3, 4, 5)

    // Kotlin nie ma domyślnego typu StringArray należy więc użyć funkcji arrayOf
    val stringArray = arrayOf("array", "of", "strings")
    val stringArray2 = arrayOf<String>("array", "of", "strings")
    var newEmptyArray = emptyArray<String>()

    // Możemy dodawać dwie tablice
    val newArray = stringArray + stringArray2

    // tylko gdy zmienna jest var
    newEmptyArray += "array"

    /*
    * Podczas inicjowania tablicy (lub czegokolwiek innego) sekwencją argumentów, można dodać przecinek na końcu.
    * Może to być przydatne, jeśli chcesz dodać lub zmienić niektóre wartości
    */
    val numbers2 = intArrayOf(1, 2, 3, 4,)

    // Tworzenie tablicy o określonym rozmiarze. Są one wypełniane domyślnymi wartościami odpowiednich typów.
    val numbers3 = IntArray(5)

    /*
    * Inną opcją jest użycie konstruktora Array, który przyjmuje rozmiar tablicy i funkcji zwracającej wartości elementów
    * tablicy z podanym indeksem lub stałą wartością lub użycie kombinacji funkcji apply scope i metody fill(), która wypełnia tablicę określonym elementem.
    */
    val numbers4 = IntArray(10) { i -> i + 1 }
    // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
    val numbers5 = IntArray(10) { 1 }
    // 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
    val numbers6 = IntArray(10).apply { fill(-1) }
    // -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    val numbers7 = IntArray(5) { readln().toInt() }

    // Dostęp do elementów
    val elem = numbers[0]

    // Funkcja ta zwraca wartość true, gdy dwie tablice zawierają te same elementy w tej samej kolejności
    numbers.contentEquals(numbers2)

    // Operator == porównuje referencje tablic
    numbers == numbers2
}