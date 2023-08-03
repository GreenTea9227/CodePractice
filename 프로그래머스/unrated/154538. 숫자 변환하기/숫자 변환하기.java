import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        int[] ints = new int[y+1];
        Arrays.fill(ints,Integer.MAX_VALUE);
        ints[y] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.offer(y);
        
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == x) {
                break;
            }
            if (cur % 2 == 0) {
                ints[cur/2] = Math.min(ints[cur] + 1,ints[cur/2]);
                queue.offer(cur/2);
            }
            if (cur % 3 == 0) {
                ints[cur/3] =Math.min(ints[cur] + 1,ints[cur/3]);
                queue.offer(cur/3);
            }
            if (cur - n >= x) {
                ints[cur-n] =Math.min(ints[cur] + 1,ints[cur-n]);
                queue.offer(cur-n);
            }
            
        }
        
        return ints[x] == Integer.MAX_VALUE ? -1 : ints[x];
    }
}