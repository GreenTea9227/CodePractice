import java.util.*;
import java.util.Set;

class Solution {
    public int solution(int[] A, int[] B) {
     Arrays.sort(A);
            Arrays.sort(B);

            int index = B.length-1;
            int count = 0;
            for (int i = A.length-1; i >=0; i--) {
                if (A[i] < B[index]) {
                    index--;
                    count++;
                }
                
            }
            
            return count;
        
    }
}