package org.example

fun main() {
    repeat(3) { // najprostrza pętla powtarzająca blok kodu określoną ilośc razy
        println("Hello")
    }

    repeat(3) { index ->
        println("Hello with index $index")
        println()
    }

    do { //while i do while tak samo jak w JAVA
    } while (true)

    while (true) {
    }
}