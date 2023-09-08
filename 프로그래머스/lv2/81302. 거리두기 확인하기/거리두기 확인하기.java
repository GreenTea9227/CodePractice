import java.util.*;

class Solution {
    int[] nx = new int[]{0,0,1,-1};
    int[] ny = new int[]{1,-1,0,0};
    
    int[] answer = new int[5];
    public int[] solution(String[][] places) {
        
        Arrays.fill(answer,1);
        
        for (int k=0;k<5;k++) {
            boolean[][] visited =new boolean[5][5];
            
            for (int i=0;i<5;i++) {
                for (int j=0;j<5;j++) {
                    if (places[k][i].charAt(j) == 'P') {
                        visited[i][j] =true;
                        dfs(places[k],k,0,j,i,visited);
                        visited[i][j] =false;
                    }
                }
            }
        }
        return answer;
    }
    
    
    public void dfs(String[] strs,int k,int distance,int x,int y,boolean[][] visited) {
        if (distance > 2)
            return;
        
        if (distance > 0 && strs[y].charAt(x) == 'P') {
            answer[k] = 0;
            return;
        }
            
        for (int i=0;i<4;i++) {
            int xx = nx[i] + x;
            int yy = ny[i] + y;
                    
            if (xx<0 || xx>=5 || yy<0 || yy>=5 || visited[yy][xx])
                continue; 
            
            if ( strs[yy].charAt(xx) != 'X')  {
                 visited[yy][xx] =true;
                 dfs(strs,k,distance+1,xx,yy,visited);
                visited[yy][xx] =false;
            }
        }
    }

}