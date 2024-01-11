
fun main() {

    var (N, S) = readLine()!!.split(" ").map { it.toInt() }
    val list = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    list.add(0)

    var len = Int.MAX_VALUE
    var start = 0
    var end = 0
    var sum = 0
    while (start <= N && end <= N) {

        if (sum >= S && len > end - start) {
            len = end - start
        }

        if (sum < S) {
            sum += list[end++]
        } else {
            sum -= list[start++]
        }
    }

    println(if (len == Int.MAX_VALUE) 0 else len)

}


