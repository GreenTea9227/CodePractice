

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, L, R;
    static int[][] map;

    static int[] arrx = new int[]{0,0,-1,1};
    static int[] arry = new int[]{-1,1,0,0};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count=0;
        while (true) {
            boolean flag = true;

            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        boolean move = move(j, i);
                        if (move)
                            flag = false;
                    }
                    visited[i][j]=true;
                }
            }
            if (flag)
                break;
            count++;
        }
        System.out.println(count);

    }

    private static boolean move(int x, int y) {

        List<int[]> list = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int sum =0;

        queue.offer(new int[]{x,y});
        list.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cx = poll[0];
            int cy = poll[1];
            sum += map[cy][cx];

            for (int i = 0; i < 4; i++) {

                int nx = cx + arrx[i];
                int ny = cy + arry[i];

                if (!(nx >=0 && nx<N && ny>=0 && ny<N))
                    continue;

                int r = Math.abs(map[ny][nx] - map[cy][cx]);
                if ( !visited[ny][nx] && r>=L && r<=R) {
                    list.add(new int[]{nx,ny});
                    queue.offer(new int[]{nx,ny});
                    visited[ny][nx] = true;
                }
            }

        }
        int number = sum / list.size();
        for (int[] ints : list) {
            int cx = ints[0];
            int cy = ints[1];
            map[cy][cx] = number;
        }

        return list.size() != 1;
    }
}
