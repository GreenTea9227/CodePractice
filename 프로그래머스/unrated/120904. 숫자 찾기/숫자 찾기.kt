class Solution {
    fun solution(num: Int, k: Int) : Int = "$num".map { it.digitToInt() }.indexOf(k).let { if (it != -1) it+1 else it  }
}