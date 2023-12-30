class Solution {
    fun solution(sides: IntArray): Int {
        sides.sort()
        return if (sides[2] >= sides[1] + sides[0] ) 2 else 1
    }
}