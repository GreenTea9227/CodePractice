import kotlin.math.max

fun main() {
    val N = readLine()!!.toInt()

    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

    val left = findDp(N, arr)
    val right = findDp(N, arr.reversedArray()).reversedArray()

    var answer = 0
    for (i in 0..left.lastIndex) {
        answer = max(answer, left[i] + right[i] - 1)
    }
    println(answer)
}

private fun findDp(N: Int, arr: IntArray): IntArray {
    val dp = IntArray(N)
    dp[0] = 1
    for (i in 1 until N) {
        dp[i] = 1
        for (j in 0 until i) {
            if (arr[i] > arr[j])
                dp[i] = max(dp[i], dp[j] + 1)
        }
    }
    return dp
}
