import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
       Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int work : works) {
            queue.offer(work);
        }
        for (int i=0;i<n && queue.size()>=1;i++) {
             int e = queue.poll() - 1;
            if (e !=0)
                queue.offer(e);
        }
        
        return queue.stream().mapToLong(i -> (long) i *i).sum();
    }
}