import java.util.*;

class Solution {
    
    int[] nx = new int[]{0,0,1,-1};
    int[] ny = new int[]{1,-1,0,0};
    int N,M;
    
    public int solution(String[] maps) {
        N = maps.length;
        M = maps[0].length();
        
        int sx =0,sy=0;
        int lx=0,ly=0;
        int ex=0,ey=0;
        
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                switch (maps[i].charAt(j)) {
                    case 'S' -> {
                        sx = j ;
                        sy = i;
                    }
                    case 'L' -> {
                        lx = j;
                        ly = i;
                    }

                    case 'E' -> {
                        ex = j;
                        ey = i;
                    }

                }
                    
            }
        }
        
        int startToLever = bfs(maps,sx,sy,lx,ly);
        int leverToEnd = bfs(maps,lx,ly,ex,ey);
        
        return startToLever == -1 || leverToEnd == -1 ? -1 : startToLever + leverToEnd;
    }
    
    private int bfs(String[] maps,int sx,int sy,int ex, int ey) {
        
        int[][] distance = new int[N][M];
        distance[sy][sx] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx,sy});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i=0;i<4;i++) {
                int xx = cx + nx[i];
                int yy = cy + ny[i];
                if (xx<0 || xx >= M || yy<0 || yy >= N || distance[yy][xx] != 0 || maps[yy].charAt(xx)=='X')
                    continue;
                
                distance[yy][xx] = distance[cy][cx] + 1;
                queue.offer(new int[]{xx,yy});
            }
        }
        
        return distance[ey][ex]-1;
    }
    
}