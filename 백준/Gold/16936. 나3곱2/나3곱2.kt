
lateinit var map: MutableMap<Long, Int>
var answer = ""


fun main() {
    val N = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toLong() }
    map = arr.groupingBy { it }.eachCount().toMutableMap()

    for (i in arr) {
        map[i] = map[i]!! - 1
        find(i,N-1,"$i")
        map[i] = map[i]!! + 1
        if (answer.isNotEmpty()) {
            println(answer.trim())
            return
        }
    }
}

fun find(num:Long, depth:Int, ans:String) {
    if (depth == 0) {
        answer = ans
        return
    }

    var next = 0L
    if (num % 3 == 0L) {
        next = num/3
        next(next, depth, ans)
    }

    next = num * 2
    next(next, depth, ans)
}

private fun next(next: Long, depth: Int, answer: String) {
    if (map.getOrDefault(next, 0) > 0) {
        map[next] = map[next]!! - 1
        find(next, depth - 1, "$answer $next")
        map[next] = map[next]!! + 1
    }
}



