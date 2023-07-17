import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int[] check = new int[26];
        Arrays.fill(check,-1);
        int[] answer = new int[s.length()];
        
        for (int i=0;i<s.length();i++) {
            int c = s.charAt(i)-'a';
            
            if (check[c] == -1) {
                answer[i] = -1;
            } else {
                answer[i] = i - check[c];
            } 
             check[c] = i;
            
        }
        
        return answer;
    }
}