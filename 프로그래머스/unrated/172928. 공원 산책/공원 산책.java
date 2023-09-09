import java.util.*;

class Solution {
    Map<String,int[]> map;
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int x = 0;
        int y = 0;
        for (int i=0;i<park.length;i++) {
            for (int j=0;j<park[i].length();j++) {
                if (park[i].charAt(j)=='S') {
                    x = j;
                    y = i;
                }
            }
        }
        map = new HashMap<>();
        map.put("E",new int[]{1,0});
        map.put("N",new int[]{0,-1});
        map.put("S",new int[]{0,1});
        map.put("W",new int[]{-1,0});
        for (String s : routes) {
            String[] strs = s.split(" ");
            String dir = strs[0];
            int move = Integer.parseInt(strs[1]);
            int[] next = map.get(dir);
           if (logic(park,dir,move,x,y)) {
                x +=  move * next[0];
                y +=  move * next[1];
           };
          
            
        }
        return new int[]{y,x};
    }
    
    private  boolean logic(String[] park, String dir,int move, int cx, int cy) {
        int[] next = map.get(dir);
        while (move > 0) {
            cx += next[0];
            cy += next[1];
            if (cx<0 || cx>=park[0].length() || cy<0 || cy>=park.length || park[cy].charAt(cx) == 'X') {  
                return false;
            }
            move--;    
        }
        return true;
    }
}