

class Solution {
    fun solution(my_string: String) = my_string
        .filter { it.isDigit() }
        .map { it.digitToInt() }
        .reduce { first, second -> first+second }
}
