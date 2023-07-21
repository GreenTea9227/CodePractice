import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int i=0;i<skill_trees.length;i++) {
            int first =0;
            int second = 0;
            int[] skillArr = new int[skill.length()];
            Arrays.fill(skillArr,Integer.MAX_VALUE);
            
            String str = skill_trees[i];
            for (int j=0;j<skill.length();j++) {
                for (int k=0;k<str.length();k++) {
                    if (skill.charAt(j) == str.charAt(k)) {
                        skillArr[j] = k;
                    }
                }
            }
            boolean flag = true;
             for (int j=0;j<skillArr.length-1;j++) {
                 if (skillArr[j] > skillArr[j+1]) {
                    flag = false;
                     break;
                 }
             }
            if (flag) {
                answer++;
            }
        }
        return answer;
    }
}