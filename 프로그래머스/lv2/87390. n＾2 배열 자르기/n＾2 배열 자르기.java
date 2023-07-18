import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
       int[] answers = new int[(int) (right - left + 1)];
        int seq=0;
        for (long i = left; i <= right; i++) {
            long f1 = i/n;
            long f2 = i%n;
            
            answers[seq++] = (int) (Math.max(f1,f2)+1);
            
        }
        return answers;
    }
}