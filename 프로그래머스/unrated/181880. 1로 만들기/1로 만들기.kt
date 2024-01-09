class Solution {
    fun solution(num_list: IntArray): Int {
        return num_list.map {
            generateSequence(it) {num ->
                if (num %2 ==0) num/2
                else (num-1)/2
            }.takeWhile { num -> num != 1 }.count()
        }.sum()
    }

}