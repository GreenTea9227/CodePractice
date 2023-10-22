import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int[] firstMinus = new int[sequence.length];
        int[] secondMinus = new int[sequence.length];
        
        for (int i=0;i<firstMinus.length;i++) {
            firstMinus[i] = i%2 ==0 ?  -sequence[i] :  sequence[i];  
            secondMinus[i] = i%2 ==0 ?  sequence[i] :  -sequence[i];   
        }
   
        return Math.max(logic(firstMinus),logic(secondMinus));

    }

    private long logic(int[] arr) {

        long[] dp = new long[arr.length];
        dp[0] = arr[0];
        long ans = dp[0];
        for (int i=1;i<arr.length;i++) {
            dp[i] = Math.max(arr[i],dp[i-1]+arr[i]);
            ans =Math.max(dp[i],ans);
        }
        return ans;
    }
}