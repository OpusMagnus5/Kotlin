data class Person(val name: String, val age: Int): Comparable<Person> {
    /*
    * Interfejs Comparable służy do definiowania naturalnej kolejności obiektów.
    * Gdy klasa implementuje Comparable, musi nadpisać metodę compareTo()
    */
    override fun compareTo(other: Person): Int {
        return this.age - other.age
    }

    fun example11() {
        val people = listOf(
            Person("Alice", 25),
            Person("Bob", 30),
            Person("Charlie", 20)
        )

        val minimum = Person("Jack", 28)
        /*
        * coerceAtLeast() - ta funkcja sprawdza, czy obiekt wywołujący jest większy niż określony obiekt minimalny.
        * Zwraca bieżący obiekt, jeśli jest większy; w przeciwnym razie zwraca obiekt minimalny
        *
        * coerceAtMost() - ta funkcja sprawdza, czy obiekt wywołujący jest mniejszy niż podany obiekt maksymalny.
        * Zwraca bieżący obiekt, jeśli jest mniejszy; w przeciwnym razie zwraca maksymalny obiekt.
        *
        * coerceIn() - ta funkcja sprawdza, czy obiekt wywołujący znajduje się w określonym zakresie między wartościami minimalnymi i maksymalnymi.
        * Zwraca ona obiekt, jeśli mieści się on w zakresie, minimum, jeśli obiekt jest mniejszy niż minimum, lub maksimum, jeśli obiekt jest większy niż maksimum.
        */
        println(people[0].age.coerceAtLeast(minimum.age))
        println(people[0].age.coerceAtMost(minimum.age))
        println(25.coerceIn(18..28))
    }

    /*
    * Gdy klasa implementuje komparator, musi nadpisać metodę compare(), która przyjmuje dwa obiekty tego samego typu jako argumenty i zwraca wartość całkowitą.
    * Zwraca zero, jeśli argumenty są równe, liczbę ujemną, jeśli pierwszy argument jest mniejszy niż drugi, lub liczbę dodatnią, jeśli pierwszy argument jest większy niż drugi.
    */
    class PersonAgeComparator : Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int {
            return p1.age - p2.age
        }
    }
}