class Solution {
    fun solution(my_string: String, n: Int) : String {
        val sb = StringBuilder()
        for (c in my_string) {
            for (i in 0..(n - 1))
                sb.append(c)
        }
        return sb.toString()
    }

}