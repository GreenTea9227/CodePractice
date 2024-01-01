
val list = mutableListOf<Int>()
var answer = 0

fun main() {
    val T = readLine()!!.toInt()
    readLine()!!.split(" ")
        .map { list.add(it.toInt()) }

    logic(0, 0)

    println(answer)
}

fun logic(count: Int, sum: Int) {

    if (list.size == 2) {
        answer = Math.max(answer, sum)
        return
    }

    for (index in 1..(list.lastIndex - 1)) {
        val temp = list[index]
        val addNum = sum + list[index - 1] * list[index + 1]
        list.removeAt(index)
        logic(count + 1, addNum)
        list.add(index, temp)
    }
}
