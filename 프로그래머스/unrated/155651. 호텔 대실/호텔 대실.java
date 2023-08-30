import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        Queue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        
        Arrays.sort(book_time,(o1,o2)->{
            return o1[0].compareTo(o2[0]);
        });
       
        
        for (String[] book : book_time) {
            int first = changeToMinute(book[0]);
            int second = changeToMinute(book[1])+10;
            while (!queue.isEmpty() && queue.peek()[1] <= first) {
                queue.poll();
            }
            queue.offer(new int[]{first,second});
            
            answer =Math.max(queue.size(),answer);
                                  
        }
        
        return answer;
    }
    
    private int changeToMinute(String num) {
        String[] time = num.split(":");
        return Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    }
}