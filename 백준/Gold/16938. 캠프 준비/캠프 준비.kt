
var answer = 0
var N = 0
var L = 0
var R = 0
var X = 0
var list: List<Int> = emptyList()
var numbers = mutableListOf<Int>()
var visited: BooleanArray = booleanArrayOf()

fun main() {
    val inputList = readLine()!!.split(" ").map { it.toInt() }
    N = inputList[0]
    L = inputList[1]
    R = inputList[2]
    X = inputList[3]
    list = readLine()!!.split(" ").map { it.toInt() }.sorted()
    visited = BooleanArray(list.size)

    for (i in 2..list.size) {
        deep(0, i)
    }
    println(answer)
}

fun deep(current: Int, count: Int) {
    if (count == 0 && numbers.last() - numbers.first() >= X && numbers.sum() in L..R) {
        answer++
        return
    }

    for (i in current until list.size) {
        numbers.add(list[i])
        deep(i + 1, count - 1)
        numbers.removeLast()
    }
}

