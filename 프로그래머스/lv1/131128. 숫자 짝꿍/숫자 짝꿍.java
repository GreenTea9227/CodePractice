import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        int[] numbers = new int[10];
        for (int i=0;i<X.length();i++) {
            numbers[X.charAt(i)-'0']++;
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i=0;i<Y.length();i++) {
            int num = Y.charAt(i)-'0';
            int count = numbers[Y.charAt(i)-'0'];
            if (count >0) {
                queue.offer(num);
                    numbers[Y.charAt(i)-'0']--;
            }
        }
        if (queue.size() == 0)
            return "-1";
        if (queue.peek() == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        
        return sb.toString();
    }
}