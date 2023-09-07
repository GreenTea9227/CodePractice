import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
      
        int low =0;
        int high = 200000000;
        int mid = 0;
        
        while (low <= high) {
            mid = (low + high)/2;
            if (check(stones,mid,k)) {
                low = mid+1;
                answer = Math.max(answer,mid);
            } else {
                high = mid-1;
            }
           
        }
      
        return answer;
        
    }
    
    private boolean check(int[] stones,int person,int k) {
        int skip = 0;
        for (int i=0;i<stones.length;i++) {
            if (stones[i] < person) {
                skip++;
            } else {
                skip =0;
            }
            if (skip == k) {
                return false;
            }
        }
        return true;
    }

    
}