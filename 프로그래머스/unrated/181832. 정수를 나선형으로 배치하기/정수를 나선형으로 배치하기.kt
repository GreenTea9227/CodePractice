class Solution {
    fun solution(n: Int): Array<IntArray> {
        val ax = intArrayOf(1, 0, -1, 0)
        val ay = intArrayOf(0, 1, 0, -1)
        val arr = Array(n) { IntArray(n) }

        var start = 1
        var direct = 0
        var cx = 0
        var cy = 0

        while (start <= n * n) {
            while (true) {
                arr[cy][cx] = start++
                val nexty = cy + ay[direct]
                val nextx = cx + ax[direct]

                if (nexty < 0 || nextx < 0 || nexty >= n || nextx >= n || arr[nexty][nextx] != 0)
                    break
                cy = nexty
                cx = nextx
            }
            direct = (1 + direct) % 4
            cy += ay[direct]
            cx += ax[direct]
        }
        return arr
    }
}