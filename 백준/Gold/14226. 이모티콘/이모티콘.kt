
import java.util.*


fun main() {
    val target = readLine()!!.toInt()

    val set = HashSet<String>()

    val queue = LinkedList<Node>()
    set.add("1 0")
    queue.offer(Node(1,0,0))


    while (!queue.isEmpty()) {
        val node = queue.poll()
        if (node.total == target) {
            println(node.time)
            break
        }

        // 1. 현재 클립 보드 붙이기
        if (!set.contains("${node.total+node.clipboard} ${node.clipboard}")) {
            set.add("${node.total+node.clipboard} ${node.clipboard}")
            queue.offer(Node(node.total+node.clipboard, node.clipboard,node.time+1))
        }


        // 2. 현재 이모티콘 복사
        if (!set.contains("${node.total} ${node.total}")) {
            set.add("${node.total} ${node.total}")
            queue.offer(Node(node.total,node.total,node.time+1))
        }


        // 3. 화면 이모티콘 삭제
        if (node.total > 0 && !set.contains("${node.total-1} ${node.clipboard}")) {
            set.add("${node.total-1} ${node.clipboard}")
            queue.offer(Node(node.total-1,node.clipboard,node.time+1))
        }

    }
}

private class Node(val total:Int,val clipboard:Int,val time:Int)







