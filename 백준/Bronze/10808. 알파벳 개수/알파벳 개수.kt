fun main(args: Array<String>) {
    println(IntArray(26).apply { readLine()!!.forEach { this[it - 'a']++ } }.joinToString(" "))
}