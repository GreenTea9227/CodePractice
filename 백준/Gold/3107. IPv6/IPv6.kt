
fun main() {
    var input = readLine()!!
    if (input.startsWith(":")) {
        input = "0$input"
    }

    if (input.contains("::")) {
        val parts = input.split("::")
        val count1 = parts[0].count { it == ':' }
        val count2 = parts[1].count { it == ':' }
        if (parts.size < 8) {
            input = "${parts[0]}${":0".repeat(8 - count1 - count2 - 2)}:${parts[1]}"
        }
    }

    val finalParts = input.split(":").toTypedArray()

    for (i in finalParts.indices) {
        finalParts[i] = "0".repeat(4 - finalParts[i].length) + finalParts[i]
    }

    println(finalParts.joinToString(":"))
}





