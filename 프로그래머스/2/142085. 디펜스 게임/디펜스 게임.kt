import java.util.PriorityQueue

class Solution {
     fun solution(n: Int, k: Int, enemy: IntArray): Int {

        val queue = PriorityQueue<Int> { a, b -> b - a }
        var person = n
        var ticket = k
        var round = 0
        while (round < enemy.size) {

            person -= enemy[round]
            queue.offer(enemy[round])

            if (person < 0) {
                while (ticket > 0 && !queue.isEmpty() && person < 0) {
                    person += queue.poll()
                    ticket--
                }

                if (person < 0)
                    break
            }

            round++
        }
        return round
    }
}