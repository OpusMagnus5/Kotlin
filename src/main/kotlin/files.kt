import java.io.File

fun example22() {

    val fileName = "src/reading.txt"
    val file = File(fileName)
    val readText = file.readText()
    file.exists()
    val readLines = file.readLines()
    file.readBytes()
    file.forEachLine { println(it) }
    File.separator
}