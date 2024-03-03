import java.util.*

private const val MAX_LINE = 100_000

fun main() {
    val sc = Scanner(System.`in`)
    val N = sc.nextInt()
    var K = sc.nextInt()

    val visited = IntArray(MAX_LINE + 1) {-1}

    val queue = ArrayDeque<Int>()
    visited[N] = 0
    queue.offer(N)

    while (queue.isNotEmpty()) {
        val poll = queue.poll()

        if (poll == K) {
            val stack = Stack<Int>()
            val answer = StringBuilder(stack.capacity())

            var current =  poll
            while (current != N) {
                stack.push(current)
                current = visited[current]
            }
            val time = stack.size
            stack.push(current)

            while (stack.isNotEmpty()) {
                answer.append(stack.pop()).append(" ")
            }

            println(time)
            println(answer)
            break
        }

        val nextMinus = poll - 1
        val nextPlus = poll + 1
        val nextMul = poll * 2

        if (nextMinus in 0..MAX_LINE && visited[nextMinus] == -1) {
            visited[nextMinus] = poll
            queue.offer(nextMinus)
        }

        if (nextPlus in 0..MAX_LINE && visited[nextPlus] == -1) {
            visited[nextPlus] = poll
            queue.offer(nextPlus)
        }

        if (nextMul in 0..MAX_LINE && visited[nextMul] == -1) {
            visited[nextMul] = poll
            queue.offer(nextMul)
        }
    }
}
