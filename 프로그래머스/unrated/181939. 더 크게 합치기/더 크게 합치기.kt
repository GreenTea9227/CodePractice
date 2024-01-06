class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var f1 = a.toString()
        var f2 = b.toString()
        return  Math.max((f1+f2).toInt(),(f2+f1).toInt())
    }
}