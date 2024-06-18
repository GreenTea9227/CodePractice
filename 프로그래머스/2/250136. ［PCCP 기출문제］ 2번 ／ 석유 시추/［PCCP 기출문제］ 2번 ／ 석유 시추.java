import java.util.*;

class Solution {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    boolean[][] check;
    public int solution(int[][] land) {
        check = new boolean[land.length][land[0].length];
        int[] oil = new int[land[0].length];
        int answer = 0;
        
        for (int i=0;i<land.length;i++) {
            for (int j=0;j<land[i].length;j++) {
                if (check[i][j] || land[i][j]==0)
                    continue;
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{j,i});
                check[i][j]=true;
                int count = 1;
                int min = j;
                int max = j;
                while (!queue.isEmpty()) {
                    int[] poll = queue.poll();
                    int x = poll[0];
                    int y = poll[1];
                    min = Math.min(min,x);
                    max = Math.max(max,x);

                    for (int k=0;k<4;k++) {
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if (ny>=0 && ny<land.length && nx>=0 && nx<land[0].length && land[ny][nx]==1 && !check[ny][nx]) {
                            check[ny][nx] = true;
                            queue.offer(new int[]{nx,ny});
                            count++;
                        }
                    }
                }
                
                for (int k=min;k<=max;k++) {
                    oil[k] += count;
                }
            }
        }
        return Arrays.stream(oil).max().getAsInt();
    }

}