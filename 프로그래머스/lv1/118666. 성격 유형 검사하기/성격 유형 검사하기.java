import java.util.*;

class Solution {
     String mbti = "RTCFJMAN";
    public  String solution(String[] survey, int[] choices) {
        int[] scores = new int[8];
        StringBuilder answer = new StringBuilder();
        for (int i=0;i<survey.length;i++) {

            char c1 = survey[i].charAt(0);
            char c2 = survey[i].charAt(1);
            int score = choices[i];

            if (score > 4 ) {
                scores[mbti.indexOf(c2)] += score-4;
            } else if (score < 4) {
                scores[mbti.indexOf(c1)] +=  4 - score;
            }
        }
        for (int i=0;i<8;i+=2) {
            if (scores[i] >= scores[i+1]) {
                answer.append(mbti.charAt(i));
            } else {
                answer.append(mbti.charAt(i+1));
            }
        }
        return answer.toString();
    }
}