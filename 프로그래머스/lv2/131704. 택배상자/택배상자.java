import java.util.*;

class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> second = new Stack<>();
        Stack<Integer> first = new Stack<>();  
        for (int i=order.length; i>=1; i--) {
            first.push(i);
        }        
        
        int count=0;
        
        while (first.size() > 0) {
            
            if (first.size() > 0 && first.peek() == order[count]) {
                first.pop();
                count++;
                continue;
            }
            
            if (second.size() > 0 && second.peek() == order[count]) {
                second.pop();
                count++;
                continue;
            }
                 
            if (first.size() > 0) 
                second.push(first.pop());         
        }  
        
        while (!second.empty()) {
            if (second.pop() == order[count])
                count++;
            else
                break;
        }
          
        return count;
    }
}