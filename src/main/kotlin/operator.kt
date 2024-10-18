
/*
* Kotlin pozwala na definiowanie własnych operatorów na określonych typach.
* Operatory te mają predefiniowaną reprezentację symboliczną, taką jak "+" lub "+=", oraz pierwszeństwo
*/
operator fun String.unaryMinus() = this.reversed()

/*
* Kotlin pozwala na wywoływanie niektórych funkcji bez użycia kropki i nawiasów. Są one nazywane infiksami np
* map(
  1 to "one",
  2 to "two",
  3 to "three"
)
*
*/

/*
* +a # a.unaryPlus()
* -a # a.unaryMinus()
* !a # a.not()
*
* a++ # a.inc()
* a-- # a.dec()
*
* a + b # a.plus(b)
* a - b # a.minus(b)
* a * b # a.times(b)
* a / b # a.div(b)
* a % b # a.rem(b)
* a..b  # a.rangeTo(b)
*
* a in b # b.contains(a)
* a !in b # !b.contains(a)
*
* a[i] # a.get(i)
* a[i, j] # a.get(i, j)
* a[i_1, ..., i_n] # a.get(i_1, ..., i_n)
* a[i] = b # a.set(i, b)
* a[i, j] = b # a.set(i, j, b)
* a[i_1, ..., i_n] = b # a.set(i_1, ..., i_n, b)
*
* a() # a.invoke()
* a(i) # a.invoke(i)
* a(i, j) # a.invoke(i, j)
* a(i_1, ..., i_n) # a.invoke(i_1, ..., i_n)
*
* a += b # a.plusAssign(b)
* a -= b # a.minusAssign(b)
* a *= b # a.timesAssign(b)
* a /= b # a.divAssign(b)
* a %= b # a.remAssign(b)
*
* a == b # a?.equals(b) ?: (b === null)
* a != b # !(a?.equals(b) ?: (b === null))
*
* a > b # a.compareTo(b) > 0
* a < b # a.compareTo(b) < 0
* a >= b # a.compareTo(b) >= 0
* a <= b # a.compareTo(b) <= 0
*/
infix operator fun String.times(n: Int) = this.repeat(n)

fun example13() {
    val name = "Kotlin"
    println(-name) // niltoK
    println(name * 3) //KotlinKotlinKotlin
}

