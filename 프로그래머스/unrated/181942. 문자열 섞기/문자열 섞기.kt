class Solution {
    fun solution(str1: String, str2: String) = str1.mapIndexed { index, char ->
            "$char${str2[index]}"
        }.joinToString("")
}