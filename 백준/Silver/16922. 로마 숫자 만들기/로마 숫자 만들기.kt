
private var answer = 0
private val visited = BooleanArray(1001)
private val numbers = intArrayOf(1, 5, 10, 50)
private var n = 0

fun main(args: Array<String>) {

    n = readLine()!!.toInt();

    dfs(0,0, 0)
    println(answer)
}

fun dfs(depth: Int,index: Int, sum: Int) {
    if (depth == n) {
        if (!visited[sum]) {
            visited[sum] = true
            answer++

        }
        return
    }


    for (i in index..3) { // 중복탐색안되게끔 index 설정
        dfs(depth + 1, i, sum + numbers[i])
    }

}

