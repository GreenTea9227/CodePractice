import java.util.*;
import java.util.stream.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>((a,b) -> b-a);
        Arrays.stream(score).forEach(i -> queue.offer(i));
        
        while (queue.size() >= m) {
            int num =0;
            for (int i=0;i<m;i++) {
                num = queue.poll();
            }
            
            answer += num * m;
        }
        return answer;
    }
}