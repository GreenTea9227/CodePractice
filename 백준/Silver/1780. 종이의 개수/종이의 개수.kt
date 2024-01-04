
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

    recur(0, 0, T)

    answer.forEach { println(it) }
}

fun recur(x: Int, y: Int, n: Int) {
    if (check(x, y, n)) {
        answer[arr[y][x] + 1]++
    } else {
        val s = n / 3
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                recur(x + j * s, y + i * s, s)
            }
        }
    }
}

fun check(x: Int, y: Int, n: Int): Boolean {
    val first = arr[y][x]
    for (i in y until (y + n)) {
        for (j in x until (x + n)) {
            if (arr[i][j] != first)
                return false
        }
    }
    return true
}


