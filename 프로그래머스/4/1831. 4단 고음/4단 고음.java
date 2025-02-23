import java.lang.Math;

class Solution {
    
     int answer = 0;
    
    public int solution(int n) {
        
        dfs(n,0);
        
        return answer;
    }
    // +의 개수 소거 
    public  void dfs(int now, int depth) {
        if(now == 1&& depth ==0) {
            answer++;
            return;
        }
        
        if(now < Math.pow(3, (depth / 2))) {
            return;
        }
        
        dfs(now - 1, depth+1);
        
        if ( now % 3 ==0 && depth >= 2) {
            dfs(now / 3, depth - 2);
        }
    }
}