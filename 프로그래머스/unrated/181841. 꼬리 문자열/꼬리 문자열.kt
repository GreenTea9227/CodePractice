class Solution {
    fun solution(str_list: Array<String>, ex: String): String {
        val sb = StringBuilder()
        for (strs in str_list) {
            if (!strs.contains(ex))
                sb.append(strs)
        }
        return sb.toString()
    }
}