
fun main() {
    var str = StringBuilder(readLine()!!)
    if (str.startsWith(":")) {
        str.insert(0,"0")
    }

    if (str.contains("::")) {
        val str2 = str.split("::")
        val count1 = str2[0].count {it == ':'}
        val count2 = str2[1].count {it == ':'}
        if (str2.size < 8) {

            str = StringBuilder(str2[0])
                .append(":0".repeat(8 - count1 - count2  - 2))
                .append(":")
                .append(str2[1])
        }
    }

    val finalStr = str.split(":").toTypedArray()


    for (n in finalStr.indices) {
        finalStr[n] = "0".repeat(4 - finalStr[n].length) + finalStr[n]
    }

    println(finalStr.joinToString(":"))
}




