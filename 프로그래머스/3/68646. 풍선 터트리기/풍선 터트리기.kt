class Solution {

    lateinit var leftMin: IntArray
    lateinit var rightMin: IntArray

    fun solution(a: IntArray): Int {

        if (a.size == 1)
            return 1

        leftMin = IntArray(a.size)
        rightMin = IntArray(a.size)

        leftMin[0] = a[0]
        rightMin[a.lastIndex] = a[a.lastIndex]

        var currentMin = a[0]
        for (n in 0..a.lastIndex) {
            if (currentMin > a[n]) {
                currentMin = a[n]
            }
            leftMin[n] = currentMin
        }

        currentMin = a[a.lastIndex]
        for (n in a.lastIndex downTo 0 ) {
            if (currentMin > a[n]) {
                currentMin = a[n]
            }
            rightMin[n] = currentMin
        }

        var answer = 2
        for (i in 1..a.lastIndex-1) {
            val current = a[i]
            val left = leftMin[i-1]
            val right = rightMin[i+1]
            if (current > left && current > right) {
                continue
            }
            answer++
        }

        return answer
    }

}