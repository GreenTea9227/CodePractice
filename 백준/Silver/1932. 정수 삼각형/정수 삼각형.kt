
import kotlin.math.max


fun main() {
    val n = readLine()!!.toInt()

    val arr = Array(n) { IntArray(n) }
    repeat(n) { i ->

        arr[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    }


    for (i in 1..n-1) {
        for (j in 0..i) {
            arr[i][j] += when (j) {
                0 -> arr[i - 1][j]
                i -> arr[i - 1][j - 1]
                else -> max(arr[i - 1][j-1], arr[i - 1][j])
            }
        }
    }

    println(arr[n-1].max())
}
