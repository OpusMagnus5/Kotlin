package org.example

fun example16() {
    val person = personBuilder {
        firstName = "John"
        lastName = "Doe"
        age = 30
        address = "123 Main St"
    }

    println(buildString {
        append("I Love ")
        append("learning Kotlin")
        append(" with Hyperskill")
    })
}

@DslMarker // stosujemy gdy oznaczamy klase ktora używa DSL, builderów, funkcji roszerzających
annotation class Person3Marker

@Person3Marker
data class Person3(
    val firstName: String,
    val lastName: String,
    val age: Int,
    val address: String
)

data class PersonBuilder(
    var firstName: String = "",
    var lastName: String = "",
    var age: Int = 0,
    var address: String = ""
)

fun personBuilder(init: PersonBuilder.() -> Unit): Person3 {
    val builder = PersonBuilder()
    builder.init()
    return Person3(builder.firstName, builder.lastName, builder.age, builder.address)
}

fun buildString(action: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    action(stringBuilder) // drugi sposób na wywołanie lambda with receiver
    return stringBuilder.toString()
}
