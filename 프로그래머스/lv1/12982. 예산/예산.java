import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        int count = 0;
        Arrays.sort(d);
        for (int i : d) {
            if (i<=budget) {
                budget-=i;
                count++;
            }
        }
        
       return count;
       
    }
}