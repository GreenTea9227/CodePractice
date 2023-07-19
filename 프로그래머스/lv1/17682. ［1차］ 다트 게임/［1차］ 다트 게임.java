import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String dartResult) {
         Stack<Integer> stack = new Stack<>();
    
            for (int i=0;i<dartResult.length();i++) {
                char c = dartResult.charAt(i);
                if (c=='1' && dartResult.charAt(i+1) =='0') {
                    stack.push(10);
                    i++;
                    continue;
                }

                switch (c) {
                    case '*' -> {
                         int f1  = stack.pop();
                        if (stack.size() >= 1) {
                            int f2  = stack.pop();
                            stack.push(f2* 2);
                        }
                        stack.push(f1* 2);
                    }
                    case '#' -> {
                        int f1  = stack.pop();
                        stack.push(-f1);
                    }
                    case 'S' -> {
                        int f1  = stack.pop();
                        stack.push(f1);
                    }
                    case 'D' -> {
                        int f1  = stack.pop();
                        stack.push(f1* f1);
                    }
                    case 'T' -> {
                        int f1  = stack.pop();
                        stack.push(f1* f1*f1);
                    }
                    default ->  {
                        stack.push(c - '0');
                    }
                }
            }
            
            return stack.stream().mapToInt(i -> i).sum();
        }
    }
