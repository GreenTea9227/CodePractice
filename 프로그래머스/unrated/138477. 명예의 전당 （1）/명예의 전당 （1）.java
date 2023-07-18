import java.util.*;
import java.util.stream.*;
class Solution {
    public int[] solution(int k, int[] score) {
        
        
        List<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i=0;i<k && i<score.length;i++) {
            queue.offer(score[i]);
            list.add(queue.peek());
        }
        for (int i=k;i<score.length;i++) {
            if (queue.peek() <= score[i]) {
                queue.offer(score[i]);
                queue.poll();
            }
            list.add(queue.peek());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}