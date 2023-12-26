class Solution {
    fun solution(price: Int): Int {
        return (price * (1 - when {
            price >= 500000 -> 0.2
            price >= 300000 -> 0.1
            price >= 100000 -> 0.05
            else -> 0.0
        })).toInt()
    }
}