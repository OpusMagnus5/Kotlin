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

/*
* Dziedziczenie interfejsów
*/
interface Animal2 {
    val amountOfLimbs: Int
    fun move()
    fun communicate()
}

// rozszerzenie interfejsu Animal2
interface Bird : Animal2 {
    val canFly: Boolean
    val flyingSpeed: Int
    fun buildNest()
}

interface Flying {
    val flyingSpeed: Int
    val flyingManeuverability: Int
}

// implementacja kilku interfejsów
class Owl : Bird, Flying {

    override val flyingSpeed: Int = 100
    override val flyingManeuverability: Int = 95
    override val canFly: Boolean = true

    override fun buildNest() {
    }

    override val amountOfLimbs: Int = 2

    override fun move() {
    }

    override fun communicate() {
    }

}

// interfejs też może rozszerzać kilka interfejsów
interface FlyingBird : Bird, Flying
{
    /* ... */
}


/*
* Delegate
*/
interface MyInterface {
    fun print()
    val msg: String
}

class MyImplementation : MyInterface {
    override fun print() {
        println(msg)
    }

    override val msg: String = "MyImplementation sends regards!"
}

/*
* dostarczamy już implementacje interfejsu jeśli nam odpowiada by nie powielać kodu
* Ale jeśli np użyjemy print na MyNewClass to wydrukuje MyImplementation sends regards!
* Możemy dowolną ilośc implementowanych interfejsów delegowac do gotowych implementacji
*/
class MyNewClass(base: MyInterface) : MyInterface by base {
    override val msg = "Delegate sends regards."
}