class Solution {
    fun solution(todo_list: Array<String>, finished: BooleanArray): Array<String> =
        todo_list.indices.filter { !finished[it] }.map { todo_list[it] }.toTypedArray()
}