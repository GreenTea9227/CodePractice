fun main() {
    var answer = 0L
    val target = readLine()!!.toInt()

    val n = readLine()!!.toInt()
    val arrA = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    val listA = makeSubSumList(arrA)

    val m = readLine()!!.toInt()
    val arrB = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()
    val listB = makeSubSumList(arrB)

    var left = 0
    var right = listB.lastIndex

    while (left < listA.size && right >= 0) {
        val sum = listA[left] + listB[right]
        if (sum == target) {
            val a = listA[left]
            val b = listB[right]
            var ca = 0L
            var cb = 0L

            while (left < listA.size && listA[left] == a) {
                ca++
                left++
            }

            while (right >= 0 && listB[right] == b) {
                cb++
                right--
            }
            answer += ca * cb
        } else if (sum > target) right--
        else left++
    }



    println(answer)

}

fun makeSubSumList(arr: Array<Int>): MutableList<Int> {
    var list = mutableListOf<Int>()
    for (i in 0..arr.lastIndex) {
        var sum = 0
        for (j in i..arr.lastIndex) {
            sum += arr[j]
            list.add(sum)
        }
    }
    list.sort()
    return list
}


