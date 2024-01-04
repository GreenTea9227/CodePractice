
lateinit var arr: Array<IntArray>
var answer = IntArray(3)

fun main() {
    val T = readLine()!!.toInt()

    arr = Array(T) { IntArray(T) }

    repeat(T) { i ->
        arr[i] = readLine()!!
            .split(" ")
            .map { it.toInt() }
            .toIntArray()
    }

    recur(0, 0, T - 1, T - 1)

    answer.forEach { println(it) }
}

fun recur(x1: Int, y1: Int, x2: Int, y2: Int) {
    if (check(x1, y1, x2, y2)) {
        answer[arr[y1][x1]+1] += 1
        return
    }

    val len = (x2 - x1 + 1) / 3
    for (i in y1..y2 step len) {
        for (j in x1..x2 step len) {
            recur(j, i, j + len-1, i + len-1)
        }
    }


}

fun check(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val first = arr[y1][x1]
    for (y in y1..y2) {
        for (x in x1..x2) {
            if (arr[y][x] != first)
                return false
        }
    }
    return true
}


