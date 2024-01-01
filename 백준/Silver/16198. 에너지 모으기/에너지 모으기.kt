var answer = 0

fun main() {
    val T = readLine()!!.toInt()
    val arr = readLine()!!.split(" ")
        .map { it.toInt() }
    logic(arr,0)

    println(answer)
}

fun logic(arr : List<Int>, sum : Int) {

    if (arr.size <= 2) {
        answer = Math.max(answer, sum)
    }

    for (num in 1..(arr.lastIndex-1)) {
        val newList = arr.toMutableList()
        val addNum = newList[num-1] * newList[num+1]
        newList.removeAt(num)
        logic(newList,sum + addNum)
    }
}
