
fun main() {
    var input = readLine()!!
    if (input.startsWith(":")) {
        input = "0$input"
    }
    input = input.replace("::", ":check:")

    val group = input.split(":").count() - 1
    input = input.replace(":check", ":0".repeat(8 - group))

    val finalParts = input.split(":")
        .map { str ->
        "0".repeat(4 - str.length) + str
        }
        .joinToString(":")

    println(finalParts)
}





