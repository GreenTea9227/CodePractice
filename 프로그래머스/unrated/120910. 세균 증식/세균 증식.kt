class Solution {
    fun solution(n: Int, t: Int): Int {
        var ans = n
        for (i in 1..t)
            ans *= 2
        return ans
    }
}