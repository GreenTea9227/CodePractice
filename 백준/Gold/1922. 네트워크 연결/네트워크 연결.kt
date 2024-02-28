import java.util.PriorityQueue

lateinit var parent: IntArray

fun main() {
    val N = readLine()!!.toInt()
    val M = readLine()!!.toInt()

    parent = IntArray(N+1) {it}

    var answer = 0

    val queue = PriorityQueue<Node>{node1 , node2 -> node1.price - node2.price}

    for (i in 1..M) {
        val list = readLine()!!.split(" ").map { it.toInt() }
        val start = list[0]
        val end = list[1]
        val price = list[2]
        queue.offer(Node(start,end,price))
    }

    while (!queue.isEmpty()) {
        val poll = queue.poll()
        val p1 = findParent(poll.start)
        val p2 = findParent(poll.end)
        if (p1 == p2) {
            continue
        }

        union(p1,p2)
        answer += poll.price
    }

    println(answer)
}


fun union(p1:Int,p2:Int) {
    parent[p2] = p1
}

fun findParent(n1: Int): Int {
    if (parent[n1] == n1)
        return n1
    parent[n1] =  findParent(parent[n1])
    return parent[n1]
}

class Node(val start: Int,val end: Int,val price: Int)



