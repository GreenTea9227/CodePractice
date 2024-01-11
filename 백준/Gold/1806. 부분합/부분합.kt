
fun main() {

    var (N, S) = readLine()!!.split(" ").map { it.toInt() }
    val list = readLine()!!.split(" ").map { it.toInt() }.toMutableList()


    var len = Int.MAX_VALUE
    var start = 0
    var end = 0
    var sum = 0
    while (end <= list.lastIndex) {
        if (sum < S) {
            sum += list[end]
            end++
        } else {
            if (len > end - start) {
                len = end - start
            }
            sum -= list[start]
            start++
        }
    }


    while (start <= list.lastIndex) {
        if (sum >= S) {
            len = minOf(end - start, len)
        }
        sum -= list[start]
        start++
    }


    println(if (len == Int.MAX_VALUE) 0 else len)


}








