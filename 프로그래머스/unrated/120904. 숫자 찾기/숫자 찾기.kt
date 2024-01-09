
    class Solution {
        fun solution(num: Int, k: Int) = num.toString().mapIndexedNotNull {
        idx,value ->
        if (k.toString() ==  value.toString())
            idx+1
        else
            null
    }.firstOrNull() ?: -1
    }
