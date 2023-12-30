class Solution {
    fun solution(array: IntArray, height: Int): Int = array.count { p -> p > height}
}