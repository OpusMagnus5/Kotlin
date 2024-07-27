package org.example

/*
* W Kotlinie istnieje pięć scope functions: let, run, with, apply i also
* Nie wykonują one żadnych konkretnych działań, a jedynie organizują kod i wykonują określone operacje w kontekście obiektu.
* Funkcje te tworzą tymczasowy zakres dla obiektów i wywołują kod z lambd.
* Wewnątrz lambdy możemy komunikować się z obiektami za pomocą słów kluczowych it lub this
*/

data class Musician(var name: String, var instrument: String, var band: String)

// APPLY
// wykonujemy kod w kontekście obiektu, obiekt kontekstu jest dostępny this, zwraca obiekt kontekstu.
fun example1() {

    val dave = Musician("Dave Grohl", "Drums", "Nirvana").apply {
        println(this)
        band = "Foo Fighters"
        instrument = "Guitar"
        println(this)
    }
}

// ALSO
/*
* Użycie also jest podobne do zastosowania apply, ale zaleca się wybranie also,
* gdy pracujesz z całym obiektem i nie dbasz o jego parametry lub metody.
* Ma również interesującą cechę - wykonuje operacje natychmiast (w rzeczywistości zwraca kontekst przed wykonaniem operacji)
*/
fun example2() {
    val instruments = mutableListOf("Guitar", "Harmonica", "Bass guitar")
    instruments
        .also { println("Right now I can play these instruments: $it") }

}