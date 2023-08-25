import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
       int[] answer = new int[2];

        int start = 0;
        int end = 0;
        int sum = 0;
        int len =Integer.MAX_VALUE;

        while (start < sequence.length) {
            if (sum > k || end == sequence.length) {
                sum -= sequence[start++];
            } else {
                sum += sequence[end++];
            }

            if (sum == k && end- start < len) {
                len = end-start;
                answer[0] = start;
                answer[1] = end-1;
            }

        }

        return answer;
    }
}