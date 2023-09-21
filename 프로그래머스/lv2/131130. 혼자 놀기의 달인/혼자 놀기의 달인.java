import java.util.*;
import java.util.stream.*;
class Solution {
    
    public int solution(int[] cards) {

        boolean[] visited = new boolean[cards.length+1];
        visited[0]=true;
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        while (check(visited) != -1) {
            int count = 0;
            int index = check(visited);
            while (!visited[index]) {
                visited[index]=true;
                count++;
                index = cards[index-1];
            }
            queue.offer(count);
        }
        
        for (int a : queue) {
            System.out.print(a+" ");
        }
        
        return queue.size() == 1 ? 0 : queue.poll() * queue.poll();
    }
    
    private int check(boolean[] visited) {
        for (int i=0;i<visited.length;i++) {
            if (!visited[i])
                return i;
        }
        return -1;
    }
}