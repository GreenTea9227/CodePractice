
lateinit var arr: Array<IntArray>
val dy = intArrayOf(1, 0, -1, 0)
val dx = intArrayOf(0, 1, 0, -1)

var N = 0
var M = 0
var R = 0


fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    N = input[0]
    M = input[1]
    R = input[2]

    arr = Array(N) { IntArray(M) }

    repeat(N) { n ->
        arr[n] = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    }

    var n = N
    var m = M
    for (i in 0 until minOf(N, M) / 2) {
        rotate(i, n * 2 + m * 2 - 4)
        n -= 2
        m -= 2
    }

    for (i in 0..arr.lastIndex) {
        for (j in 0..arr[i].lastIndex) {
            print(arr[i][j].toString() + " ")
        }
        println()
    }


}


fun rotate(start: Int, len: Int) {

    var rLen = R % len

    for (i in 0 until rLen) {
        var x = start
        var y = start
        var direction = 0
        var pre = arr[y][x]
        var temp = 0
        while (direction < 4) {
            var yy = y + dy[direction]
            var xx = x + dx[direction]
            if (yy in start until N - start && xx in start until M - start) {
                temp = arr[yy][xx]
                arr[yy][xx] = pre
                pre = temp
                y = yy
                x = xx
                continue
            }

            direction++
        }
    }


}





