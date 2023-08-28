import java.util.*;

class Solution {
    String strs = "RTCFJMAN";
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<survey.length;i++) {
            int score = choices[i];
            if (score < 4) {
                char c1 = survey[i].charAt(0);
                map.put(c1,map.getOrDefault(c1,0) + 4 - score);
            } else if (score > 4) {
                char c2 = survey[i].charAt(1);
                map.put(c2,map.getOrDefault(c2,0) + score - 4);
            }
        }
        
        for (int i=0;i<8;i+=2) {
            char c1 = strs.charAt(i);
            char c2 = strs.charAt(i+1);
            if (map.getOrDefault(c1,0) >= map.getOrDefault(c2,0)) {
                answer += c1;
            } else {
                answer += c2;
            }
        }
        return answer;
    }
}