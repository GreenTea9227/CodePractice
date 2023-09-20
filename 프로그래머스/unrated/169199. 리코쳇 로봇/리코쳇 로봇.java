import java.util.*;

class Solution {
    int[] nx = new int[]{0,0,1,-1};
    int[] ny = new int[]{1,-1,0,0};
    int N,M;
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        
        boolean[][] visited = new boolean[N][M];
        int sx=0,sy=0;
        
        
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++) {
                char c = board[i].charAt(j);
                if (c == 'R') {
                    sx = j;
                    sy = i;
                    break;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx,sy,0});
        visited[sy][sx] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i=0;i<4;i++) {
                int x = cx;
                int y = cy;
       
                while (check(x + nx[i],y + ny[i],visited,board)) {
                    x += nx[i];
                    y += ny[i];
                }
                
                if (board[y].charAt(x) == 'G') {
                    return cur[2]+1;
                }
                
                if (visited[y][x])
                    continue;
                
                queue.offer(new int[]{x,y,cur[2]+1});
                visited[y][x]=true;
            }
        }
        
        
        return -1;
    }
    
    private boolean check(int x, int y, boolean[][] visited, String[] board) {
        return x >=0 && x< M && y>=0 && y<N && board[y].charAt(x) != 'D';
    }
}