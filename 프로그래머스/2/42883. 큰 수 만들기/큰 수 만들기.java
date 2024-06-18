import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for (int i=0;i<number.length();i++) {
            char c = number.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            
            while (k>0 && !stack.isEmpty() && stack.peek() < c) {
                stack.pop();
                k--;
            }
            
            stack.push(c);
        }
        
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        StringBuilder sb =answer.reverse();
        return k>0 ? sb.substring(0,sb.length()-k).toString() : sb.toString();
      
    }
}