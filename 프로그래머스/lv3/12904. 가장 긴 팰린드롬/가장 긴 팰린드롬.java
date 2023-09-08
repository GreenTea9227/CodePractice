import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;

        for (int i=0;i<s.length()-1;i++) {
            int left =i-1;
            int right = i+1;
            int count = 1;
            while (left >= 0  && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    count+=2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
            answer =Math.max(count,answer);
            
            if (s.charAt(i) == s.charAt(i+1)) {
             left =i-1;
             right = i+2;
             count = 2;
            while (left >= 0  && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    count+=2;
                    left--;
                    right++;
                } else {
                    break;
                }
            }
                answer =Math.max(count,answer);
            }
        }

        return answer;
    }
    

     
    
}