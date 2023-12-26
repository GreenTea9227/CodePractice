import kotlin.math.sqrt

class Solution {
    fun solution(n: Int) = if (sqrt(n.toDouble()) % 1 == 0.toDouble()) 1 else 2
}