import kotlin.system.exitProcess

val sudoku = Array(9) { IntArray(9) }
val zero = mutableListOf<Node>()

fun main() {

    repeat(9) { y ->
        val line = readLine()!!
        repeat(9) { x ->
            sudoku[y][x] = line[x].digitToInt()
            if (sudoku[y][x] == 0) {
                zero.add(Node(x, y))

            }
        }
    }

    dfs(0)

}

fun dfs(depth: Int) {
    if (depth == zero.size) {
        finish()
    }

    val (x, y) = zero[depth]


    val findSudoku = findSudoku(y, x)
    if (findSudoku.isEmpty()) {
        return
    }
    for (num in findSudoku) {
        sudoku[y][x] = num
        dfs(depth + 1)
        sudoku[y][x] = 0
    }

}

fun findSudoku(i: Int, j: Int): List<Int> {
    val check = BooleanArray(10)
    val sx = j / 3 * 3
    val sy = i / 3 * 3
    for (y in sy until sy + 3) {
        for (x in sx until sx + 3) {
            check[sudoku[y][x]] = true
        }
    }
    for (x in 0..sudoku.lastIndex) {
        check[sudoku[i][x]] = true
    }
    for (y in 0..sudoku.lastIndex) {
        check[sudoku[y][j]] = true
    }

    val pre = mutableListOf<Int>()
    for (k in 1..check.lastIndex) {
        if (!check[k])
            pre.add(k)
    }
    return pre
}

fun finish() {
    repeat(9) { y ->
        repeat(9) { x ->
            print(sudoku[y][x])
        }
        println()
    }
    exitProcess(0)
}

data class Node(val x: Int, val y: Int)
