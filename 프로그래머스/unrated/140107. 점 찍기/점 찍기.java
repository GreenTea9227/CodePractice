import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long x = 0;
        long y = d;
        
        while (y>=0 && x<=d) {
            
            if (Math.sqrt(x*x + y*y) > d) {
                y-=1;
                continue;
            }
            
        
            answer += y/k + 1;
            
            x+=k;
            
        }
           
        return answer;
    }
}