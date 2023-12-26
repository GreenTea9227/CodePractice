class Solution {
    fun solution(arr1: IntArray, arr2: IntArray): Int {
        return if (arr1.size == arr2.size) {
            val a1 = arr1.sum()
            val a2 = arr2.sum()

            when {
                a1 > a2 -> 1
                a1 == a2 -> 0
                else -> -1
            }
        } else if (arr1.size > arr2.size) {
            1
        } else {
            -1
        }
    }
}