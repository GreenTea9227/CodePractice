lateinit var list: MutableList<StringBuilder>
lateinit var check: BooleanArray

fun main() {
    val T = readLine()!!.toInt()
    list = mutableListOf()
    check = BooleanArray(T)

    repeat(T) {
        val str = readLine()!!
        list.add(StringBuilder(str))
    }

    val k = readLine()!!.toInt()
    for (n in 0 until k) {
        val split = readLine()!!.split(" ").map { it.toInt() }
        totalRotate(split[0]-1, split[1])
    }

    println(list.count { it[0] == '1' })
}

fun totalRotate(index: Int, direct: Int) {
    check[index] =true
    val sb = list[index]
    val curRight = sb[2]
    val curLeft = sb[6]


    when (direct) {
        1 -> rotate(sb)
        -1 -> reverseRotate(sb)
    }

    if (index > 0 && list[index - 1][2] != curLeft && !check[index-1]) {
        totalRotate(index - 1, -direct)
    }
    if (index < list.lastIndex && list[index + 1][6] != curRight && !check[index+1]) {
        totalRotate(index + 1, -direct)
    }
    check[index] =false

}

fun rotate(sb: StringBuilder) {
    val c = sb.last()
    sb.deleteAt(sb.lastIndex)
    sb.insert(0, c)
}

fun reverseRotate(sb: StringBuilder) {
    val c = sb[0]
    sb.deleteAt(0)
    sb.append(c)
}

