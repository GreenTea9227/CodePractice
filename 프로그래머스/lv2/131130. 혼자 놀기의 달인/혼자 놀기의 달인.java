import java.util.*;
import java.util.stream.*;
class Solution {
    
    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length+1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i=1;i<=cards.length;i++) {
            if (visited[i])
                continue;
            int count = 0;
            int cur = i;
            while (!visited[cur]) {
                visited[cur]=true;
                count++;
                cur = cards[cur-1];
            }
            queue.offer(count);
        }
 
        return queue.size() == 1 ? 0 : queue.poll() * queue.poll();
    }
    

}