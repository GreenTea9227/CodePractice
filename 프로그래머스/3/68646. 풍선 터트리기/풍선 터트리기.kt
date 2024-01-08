class Solution {

    fun solution(a: IntArray): Int {

        if (a.size == 1)
            return 1

        val leftMin = IntArray(a.size)
        val rightMin = IntArray(a.size)


        var currentMin = Int.MAX_VALUE
        a.forEachIndexed { idx, num ->
            currentMin = minOf(num, currentMin)
            leftMin[idx] = currentMin
        }
        currentMin = Int.MAX_VALUE
        a.reversed().forEachIndexed { idx, num ->
            currentMin = minOf(num, currentMin)
            rightMin[idx] = currentMin
        }

        rightMin.reverse()

        return (1 until a.lastIndex).count {
            val current = a[it]
            current < leftMin[it - 1] || current < rightMin[it + 1]
        } + 2
    }
}