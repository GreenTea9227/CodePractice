import java.util.*;

class Solution {
    
    int[] nx = new int[]{0,0,1,-1};
    int[] ny = new int[]{1,-1,0,0};
    int N,M;
    
    int[][] sel;
    public int solution(String[] maps) {
        
        int answer = 0;
        
        N = maps.length;
        M = maps[0].length();
        
        sel = new int[3][2];
        for (int i=0;i<N;i++) {
            for (int j=0;j<M;j++) {
                switch (maps[i].charAt(j)) {
                    case 'S':
                        sel[0][0] = j;
                        sel[0][1] = i;
                       break;
                    case 'L':
                        sel[1][0] = j;
                        sel[1][1] = i;
                        break;
                    case 'E':
                        sel[2][0] = j;
                        sel[2][1] = i;
                        break;
                }
                    
            }
        }
        
        int first = bfs(maps,sel[0][0],sel[0][1],sel[1][0],sel[1][1]);
        int second = bfs(maps,sel[1][0],sel[1][1],sel[2][0],sel[2][1]);
        
        return first == -1 || second == -1 ? -1 : first + second;
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