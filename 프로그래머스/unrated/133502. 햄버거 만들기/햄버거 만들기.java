import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
         int ans = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int cur : ingredient) {
            if (stack.size() < 3) {
                stack.push(cur);
                continue;
            }

            int f1 = stack.pop();
            int f2 = stack.pop();
            int f3 = stack.pop();
            if (  f3 == 1 && f2 == 2 && f1 == 3 && cur == 1 ) {
              
                ans++;
            } else {
                
                stack.push(f3);
                stack.push(f2);
                stack.push(f1);
                stack.push(cur);
            }
        }
        return ans;
    }
}