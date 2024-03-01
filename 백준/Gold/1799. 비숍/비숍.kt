
import kotlin.math.max


lateinit var map: Array<IntArray>
lateinit var colors: Array<IntArray>

lateinit var bishop1: IntArray
lateinit var bishop2: IntArray
var N = 0
var answer = arrayOf(0, 0)


fun main() {
    N = readLine()!!.toInt()

    map = Array(N) { IntArray(N) }
    colors = Array(N) { IntArray(N) }

    repeat(N * N) { i ->
        val row = i / N
        val col = i % N
        if (i % 2 == 0)
            colors[row][col] = 1


    }

    bishop1 = IntArray(N * 2)
    bishop2 = IntArray(N * 2)

    repeat(N) { i ->
        map[i] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    dfs(0, 0, 0)
    dfs(1, 0, 1)


    println(answer[0] + answer[1])

}


fun dfs(seq: Int, chess: Int, color: Int) {
    if (seq >= N * N) {
        answer[color] = max(answer[color], chess)
        return
    }

    val row = seq / N
    val col = seq % N
    var next = 2
    if (N % 2 == 0) {
        if (col + 2 == N)
            next = 3
        else if (col +1 == N)
            next = 1
    }

    if (map[row][col] == 1 && check(row, col)) {
        // 설치하고 지나가기
        bishop1[row + col] = 1
        bishop2[N + (row - col)] = 1

        dfs(seq + next, chess + 1, color)

        bishop2[N + (row - col)] = 0
        bishop1[row + col] = 0
    }

    // 설치 안 하고 지나가기
    dfs(seq + next, chess, color)


}


fun check(row: Int, col: Int): Boolean {
    return bishop1[row + col] != 1 && bishop2[N + (row - col)] != 1
}
