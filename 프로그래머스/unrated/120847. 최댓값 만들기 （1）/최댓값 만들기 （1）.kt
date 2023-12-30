class Solution {
    fun solution(numbers: IntArray): Int {
        return numbers.sorted().let { it[it.size-1] * it[it.size-2] }
    }
}