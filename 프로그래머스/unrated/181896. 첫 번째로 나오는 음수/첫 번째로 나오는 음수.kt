class Solution {
    fun solution(num_list: IntArray): Int = num_list.indexOfFirst { it < 0 }
}