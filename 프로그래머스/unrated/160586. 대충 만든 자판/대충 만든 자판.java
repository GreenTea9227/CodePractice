import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int[] alpha = new int[26];
        Arrays.fill(alpha,Integer.MAX_VALUE);
        for (String s : keymap) {
            
             if (s.isBlank())
                continue;
            
            for (int i = 0; i < s.length(); i++) {
                int str = s.charAt(i) - 'A';
                alpha[str] = Math.min(alpha[str],i+1);
            }
        }
        for (int i = 0; i < answer.length; i++) {
            for (char c : targets[i].toCharArray()) {
                if (alpha[c-'A'] == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                }
                
                answer[i] += alpha[c-'A'];
            }
        }
        
        return answer;
    }
}