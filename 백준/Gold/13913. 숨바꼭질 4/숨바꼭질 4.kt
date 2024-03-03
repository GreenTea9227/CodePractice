
import java.util.*

private const val MAX_LINE = 100_000

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    var K = sc.nextInt()

    val visited = IntArray(MAX_LINE + 1)
    visited.fill(-1)

    val queue = LinkedList<Int>()
    visited[N] = 0
    queue.offer(N)

    while (!queue.isEmpty()) {
        val poll = queue.poll()

        if (poll == K) {
            val stack = Stack<Int>()
            var current =  poll
            while (current != N) {
                stack.push(current)
                current = visited[current]
            }
            val answer = StringBuilder()
            val time = stack.size

            stack.push(current)

            while (!stack.empty()) {
                answer.append(stack.pop()).append(" ")
            }

            println(time)
            println(answer)
            break
        }

        if (poll - 1 >= 0 && visited[poll -1] == -1) {
            visited[poll - 1] = poll
            queue.offer(poll - 1)
        }

        if (poll + 1 <= MAX_LINE && visited[poll + 1] == -1) {
            visited[poll + 1] = poll
            queue.offer(poll + 1)
        }

        if (poll * 2 <= MAX_LINE && visited[poll * 2] == -1) {
            visited[poll * 2] = poll
            queue.offer(poll * 2)
        }


    }
}
