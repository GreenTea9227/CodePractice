import java.util.*;

class Solution {
    public long solution(int[] sequence) {
        
        int[] firstMinus = new int[sequence.length];
        int[] secondMinus = new int[sequence.length];
        
        for (int i=0;i<firstMinus.length;i++) {
            firstMinus[i] = i%2 ==0 ?  -sequence[i] :  sequence[i];   
        }
        for (int i=0;i<secondMinus.length;i++) {
           secondMinus[i] = i%2 ==0 ?  sequence[i] :  -sequence[i];   
        }
        
        return Math.max(logic(firstMinus),logic(secondMinus));

    }
    
    private long logic(int[] arr) {
        long ans =0;
        long current = 0;

        for (int i=0;i<arr.length;i++) {
    
            if (current + arr[i] < 0) {
                current = 0;
                continue;
            }
            current = current + arr[i];
            ans = Math.max(ans,current);    
        }
        return ans;
    }
}