class Solution {
    fun solution(strlist: Array<String>): IntArray {
        return strlist.map { str -> str.length }
            .toIntArray()
    }
}