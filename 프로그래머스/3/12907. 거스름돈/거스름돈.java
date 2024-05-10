import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int[][] dp = new int[money.length+1][n+1];
        
        for (int i=1;i<dp.length;i++) {
            int coin = money[i-1];
            dp[i][coin] = 1;
            for (int j=1;j<dp[i].length;j++) {
                int plus = j < coin ? 0 : dp[i][j-coin];
                dp[i][j] += (dp[i-1][j] + plus) % 1000000007;
            }
        }
        
        return dp[dp.length-1][n];
    }
}