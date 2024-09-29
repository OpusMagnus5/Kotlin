/*
* Interfejsy określają, jakie metody i właściwości musi posiadać klasa implementująca
*/
interface Animal {
    val numberOfLimbs: Int
    fun move()

    // val age = 10 Błąd: Inicjalizatory właściwości nie są dozwolone w interfejsach

    // Możemy jednak użyć getterów, aby osiągnąć ten sam rezultat
    val age: Int
        get() = 10

    // Ponieważ metody reprezentują pewną serię działań lub określone zachowanie, domyślna implementacja dotyczy również ich:
    fun printNumberOfLimbs() {
        print(numberOfLimbs)
    }
}

// Następnie każde pole lub metoda zadeklarowana w interfejsie musi zostać zadeklarowana w klasie ze słowem kluczowym override
class Cat(): Animal {

    override val numberOfLimbs: Int = 4
    override fun move() {
    }
}