

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] arrx = {2,2,-2,-2,1,1,-1,-1};
    static int[] arry = {1,-1,1,-1,2,-2,2,-2};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T ; i++) {

            int n = sc.nextInt();
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            int ex = sc.nextInt();
            int ey = sc.nextInt();

            int[][] map = new int[n][n];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{sx,sy});

            while (!queue.isEmpty()) {
                int[] current = queue.poll();

                int cx = current[0];
                int cy = current[1];

                if (cx == ex && cy == ey) {
                    System.out.println(map[cy][cx]);
                    break;
                }

                for (int j = 0; j < arrx.length; j++) {
                    int nx = arrx[j] + cx;
                    int ny = arry[j] + cy;

                    if (  ny>=0 && ny<n  && nx>=0 && nx<n && map[ny][nx] ==0 ) {
                        queue.offer(new int[]{nx,ny});
                        map[ny][nx] += map[cy][cx]+1;
                    }
                }


            }

        }
    }


}
