
fun main() {
    val T = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toTypedArray()

    var answer = 0
    while (true) {
        for (n in arr.indices) {
            if (arr[n] % 2 != 0) {
                arr[n]--
                answer++
            }
        }
        if (arr.all { it == 0 })
            break

        for (n in arr.indices) {
            arr[n] /= 2
        }
        answer++
    }
    println(answer)
}




