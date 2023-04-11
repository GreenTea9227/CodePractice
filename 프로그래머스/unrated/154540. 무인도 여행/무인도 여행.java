import java.util.*;
import java.util.stream.*;

class Solution {
    
    int[] arrx = new int[]{1,-1,0,0};
    int[] arry = new int[]{0,0,1,-1};
    List<Integer> list = new ArrayList<>();
    boolean[][] visited;
    int mx,my;
    
    public int[] solution(String[] maps) {
        
        my = maps.length;
        mx = maps[0].length();
        visited = new boolean[my][mx];
        
        for(int i=0;i<my;i++) {
            for(int j=0;j<mx;j++) {
                if (maps[i].charAt(j) == 'X' || visited[i][j])
                    continue;
               checkIsland(i,j,0,maps);
            }
        }
        return list.size()==0 ? new int[]{-1}  : list.stream().sorted().mapToInt(i->i).toArray();
    }
    
    private void checkIsland(int i, int j,int count,String[] maps) {
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        count+= Integer.parseInt(maps[i].split("")[j]);
            
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for (int k=0;k<4;k++) {
                int nx = arrx[k]+cur[1];
                int ny = arry[k]+cur[0];
               
                if (nx >=0 && nx<mx && ny>=0 && ny<my && !visited[ny][nx] && maps[ny].charAt(nx)!='X') {
                    queue.offer(new int[]{ny,nx});
                    count+= Integer.parseInt(maps[ny].split("")[nx]);
                    visited[ny][nx] = true;
                }
            }
        }
        if (count != 0)
            list.add(count);
        
        
    }
}