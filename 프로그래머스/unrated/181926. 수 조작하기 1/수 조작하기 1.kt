class Solution {
    fun solution(n: Int, control: String): Int {
        var ans = n
        for (str in control) {
            ans += when (str) {
                'w' -> 1
                'a' -> -10
                's' -> -1
                'd' -> 10
                else -> 0
            }
        }

        return ans
    }
}