import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        int[][] scoreBoard = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        
        int totalPicks = Arrays.stream(picks).sum();
        List<int[]> list = new ArrayList<>();
        
         for(int i = 0; i < minerals.length; i+=5) {
            if(totalPicks == 0) 
                break;
             
             int dia=0;
             int iron=0;
             int stone=0;
             
             for (int j=i;j<i+5;j++) {
                 if(j == minerals.length) 
                     break;
                 String mineral = minerals[j];
                 int index = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;
                 
                dia += scoreBoard[0][index];
                iron += scoreBoard[1][index];
                stone += scoreBoard[2][index];
                 
                 
             }
             
             list.add(new int[]{dia,iron,stone});
             totalPicks--;
         }
        
        Collections.sort(list,(a,b) -> b[2] -a[2]);
        
        for (int[] m : list) {
            int dia = m[0];
            int iron = m[1];
            int stone = m[2];
           
            if(picks[0] > 0) {
                answer += dia;
                picks[0]--;
                continue;
            }
            if(picks[1] > 0) {
                answer += iron;
                picks[1]--;
                continue;
            }
            if(picks[2] > 0) {
                answer += stone;
                picks[2]--;
                continue;
            }
        }

        return answer;
    }
}