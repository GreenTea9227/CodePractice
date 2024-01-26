
import java.util.*

val set = mutableSetOf<Long>()
val queue = LinkedList<Node>()

fun main() {
    val (s, t) = readLine()!!.split(" ").map { it.toLong() }
    if (s == t) {
        println(0)
        return
    }

    val ans = mutableListOf<String>()
    set.add(s)
    queue.offer(Node(s, ""))

    while (!queue.isEmpty()) {
        val node = queue.poll()
        if (node.num == t) {
            ans.add(node.operation)
            continue
        }

        insertMap(node.num * node.num, node.operation, "*")
        insertMap(node.num + node.num, node.operation, "+")
        insertMap(0, node.operation, "-")
        if (node.num != 0L)
            insertMap(node.num / node.num, node.operation, "/")
    }

    if (ans.isEmpty()) {
        println(-1)
        return
    }

    println(ans[0])
}

fun insertMap(num: Long, curOp: String, op: String) {

    if (set.contains(num))
        return
    set.add(num)
    queue.offer(Node(num, "$curOp$op"))
}

class Node(val num: Long, val operation: String)



