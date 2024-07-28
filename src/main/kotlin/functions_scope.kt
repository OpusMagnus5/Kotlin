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

/*
* WITH
*
* Context object is available as this
* It returns the result of a lambda
* Po pierwsze, gdy chcemy zrobić coś z obiektem kontekstu i nie chcemy otrzymać wyniku.
* Poza tym używamy with, gdy chcemy utworzyć obiekt pomocniczy, którego parametry lub funkcje mogą być użyte do obliczenia wyniku.
* Ważne - ten nowy obiekt jest używany jako pomocniczy (będziemy pracować z prawdziwym obiektem w metodzie run).
*/

fun example3() {
    val musicians = mutableListOf("Thom York", "Jonny Greenwood", "Colin Greenwood")
    with(musicians) {
        println("'with' is called with the argument $this")
        println("List contains $size elements")
    }

    val firstAndLast = with(musicians) {
        "First list element - ${first()}," +
                " last list element - ${last()}"
    }
}

/*
* LET
*
* Context object is available as it
* It returns the result of a lambda
* Po pierwsze, gdy chcemy zrobić coś z operatorem bezpiecznego wywołania ? i obiektami non-null
* Po drugie, używamy let, gdy chcemy wprowadzić zmienne lokalne o ograniczonym zakresie.
* W takim przypadku let pozwala nam poprawić czytelność kodu
*/

fun example4() {
    val str: String? = "Jonny Greenwood"
    val length = str?.let {
        println("let() is called on $it")
        //processNonNullString(it)      // OK: 'it' is not null inside '?.let { }'
        it.length
    }

    val musicians = mutableListOf("Thom York", "Jonny Greenwood", "Colin Greenwood")
    val modifiedFirstItem = musicians.first().let { firstItem ->
        println("The first item of the list is '$firstItem'")
        if (firstItem.length >= 5) firstItem else "!$firstItem!"
    }.uppercase()
}

/*
* RUN
*
* Context object is available as this
* It returns the result of a lambda
* Po pierwsze, gdy chcemy zainicjować nowy obiekt i przekazać do niego wynik lambdy.
* Po drugie, gdy chcemy użyć funkcji bez rozszerzenia i wykonać blok kilku operatorów.
*/

class MultiportService(var url: String, var port: Int) {
    fun prepareRequest(): String = "Default request"
    fun query(request: String): String = "Result for query '$request'"
}

fun example5() {
    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port")
    }

    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }
}