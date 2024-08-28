package org.example
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

const val STATE: String = "Full"
// const val dla stałych zmiennych które są znane już w trakcie kompilacji
// const może być stosowanych tylko dla prymitywów
// musi być deklarowana poza funkcją, na najwyższym poziomie

fun main18() {
    val numberType: Int = 1_000_000 // tak można definiować liczby w celu czytelności
    // val deklaruje tylko zmienną do oczytu (referencje)

    var mutableType: String = "Kotlin";
    // var deklaruje zmienną którą można modyfikować

    // przypisując zmienne val do var możemy zmieniać zmienną var
    var toChangeVal: Int = numberType;
    toChangeVal = 1_111;

    println(numberType); //drukuje do konsoli, dodaje nową linię na koncu, bez nowej linii print()

    //Typ zmiennej zawsze zaczyna się z dużej litery np Int, String, Float, Double

    //Komentarze tak jak w Java
    //Komentarze dokumentujące
    /**
     * The `main` function accepts string arguments from outside.
     *
     * @param args arguments from the command line.
     */

    val `good name` = 5 // w Kotlin działają spacje w nazwie zmiennej ale musi byc w ` `

    //string templates
    val someText = "Number is $numberType" //poprzez $nazwaZmiennej wstrzykujemy do stringa
    val evaluatedExpression = "Some calculate ${numberType * 2}" // możemy również wykonywać wyrażenia za pomocą ${}
    val largeString = """
        
    """.trimIndent() // W tym bloku zachowywane są wszystkie białe znaki

    //Boolean
    // 0 nie jest false, nie można przypisywać 0 lub 1 jako boolean
    "False".toBooleanStrict() // wyjątek case sensitive
    "False".toBooleanStrictOrNull() // null
    "TruE".toBoolean() // true case insensitive
    // operatory logiczne jak w JAVA ! && || ale jest jeszcze xor
    // xor zwraca true jesli wartości są różne czyli jedna false a druga true
    val b2 = false xor true  // true
    val b4 = true xor true   // false

    //Typy liczbowe: Long, Int, Short, Byte, Double, Float
    //Tekst: Char w '', String
    //Boolean

    val longValue: Long = 100L
    //val intValue: Int = longValue nie zadziała Kotlin nie wspiera loss conversion
    longValue.toInt() // trzeba bezpośrednio konwertować
    longValue is Long // tak można sprawdzać typ
    longValue as? String //konwertuje ale nie rzuca wyjątku ClassCastException tylko zwraca null

    val uInt: UInt = 5u; // typ unsigned (bez znaku -)
    val uInt2 = 5u; //lub bez typu
    val ulong = 5uL //specjalny suffix dla usigned longa

    var name: String? = null //oznaczenie zmiennej jako nullable
    //var name2: String = null to się nie skompiluje ponieważ zmienna nie została oznaczona jako nullable

    //Handling nullables variables
    name?.length //przez dodanie pytajnika wyciągamy bezpiecznie wartośc nawet jesli jest null do dostaniemy null
    var length = name?.length ?: 0 // jeśli name jest null lub length by było null to zwrócimy 0
    var length2 = name!!.length // rzuca wyjątek NullPointer jeśli name jest null, nalaży unikac stosowania
    val x: Any = "Kotlin"
    val y: String? = x as? String //bezpieczne rzutowanie, zwraca null jeśli x jest nullem
    name?.let { //let keyword wykonuje metode jeśli nie jest nullem
        println("Name is $it")
    }

    name?.apply { //wykonanie metody która ustawia wartośc name na inną jeśli jest nullem
        // Configure object here
    }

    val positiveNumber = name.takeIf { it > "a" } // pobiera zmienną name jeśli spełnimy warunek, null jeśli nie spełnimy
    val notBlankString = name.takeUnless { it.isBlank() } // pobiera zmienną name jeśli nie spełniamy warunku, null jesli spełnimy

    if (name is String) { //zmienna sprawdzona w ten sposób wewnatrz jest automatycznie castowana na ten typ
        println(name.length)
    }

    fun String.addExclamation() = this + "!" //ZAJEBISTE można dodawać metody już do istnięjacych obiektów !!!
    var numb12: Int? = null
}

/*
* Leniwa inicjalizacja pozwala nam utworzyć obiekt dokładnie w momencie, gdy pojawi się do niego pierwsze odwołanie.
*/

fun lazyInitialization() {
    /*
    * Kotlin posiada specjalną funkcję lazy(), która akceptuje lambdę.
    * Pierwsze wywołanie wykonuje tę lambdę i zapamiętuje wynik. Kolejne wywołania po prostu zwracają tę wartość.
    * zmienne lazy muszą być zadeklarowane z val
    *
    * lazy() function's mode parameters:
    * LazyThreadSafetyMode.SYNCHRONIZED - oznacza, że wartość jest obliczana tylko w jednym wątku, a wszystkie wątki
    * otrzymają tę samą wartość. Jest to opcja domyślna, więc możesz ją pominąć, jeśli chcesz
    * LazyThreadSafetyMode.PUBLICATION - określa, że lambda może być wywołana kilka razy z niezainicjalizowaną wartością
    * leniwego obiektu, ale wartość, która zostanie zwrócona jako pierwsza, zostanie użyta
    * LazyThreadSafetyMode.NONE - oznacza, że nie ma żadnej synchronizacji, więc jeśli wywołamy zmienną z różnych wątków,
    * jej wartość nie może być jednoznacznie zdefiniowana. Korzystanie z tej opcji nie jest zalecane, jeśli program pozwala
    * na wywołanie leniwego obiektu po raz pierwszy z więcej niż jednego wątku
    */
    val a: String by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        print("Variable a is initialized. ")
        "I love Hyperskill!"
    }

    println(a) // Variable a is initialized. I love Hyperskill!
    println(a) // I love Hyperskill!

    /*
    * inny sposób to deklaracja z lateinit i poźniejsza inicjalizajca obiektu
    * zmienne lateinit muszą być zadeklarowane z var
    */

    lateinit var b: String
    b = a
    if (::a.isInitialized) // zadziała tylko na polu w obiekcie, sprawdza czy jest zainicjalizowana
        println("a is Initialized")
    else
        println("a isn't Initialized")
}

/*
* NOTHING
* Nothing jest unikalnym typem, ponieważ nie posiada instancji
* Nothing jest podtypem każdego znanego typu w Kotlinie. Oznacza to, że może reprezentować wartość dowolnego typu pod względem sprawdzania typów.
*/

fun fail(): Nothing {
    throw Exception("This function always throws an exception")
}

fun greet(): String {
    fail() // jest to dozwolone, ponieważ Nothing jest podtypem String
}

fun yetToImplementFeature(): String {
    TODO("Feature not implemented yet") // TODO rzuca NotImplementedError z podanym powodem
    println("This statement is unreachable") // To nigdy się nie wykona z powodu TODO()
}