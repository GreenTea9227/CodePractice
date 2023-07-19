import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean[] dp = new boolean[n+1];
        Arrays.fill(dp,true);
        dp[0]=false;
        dp[1]=false;
        
        for (int i=2;i<=n;i++) {
            if (dp[i]) {
                answer++;
                for (int j=i*2;j<=n;j+=i) {
                    dp[j] = false;
                }
            }
        }
        return answer;
    }
}