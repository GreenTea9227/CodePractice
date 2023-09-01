
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] nx = new int[]{1, 0, -1, 0};
    static int[] ny = new int[]{0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] visited = new boolean[n][m];
        int[][] map = new int[n][m];
        int sx = 0;
        int sy = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    sy = i;
                    sx = j;
                } else if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        int[][] answer = new int[n][m];

        visited[sy][sx] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ex = nx[i] + poll[0];
                int ey = ny[i] + poll[1];
                if (ex >= 0 && ex < m && ey >= 0 && ey < n && !visited[ey][ex]) {
                    answer[ey][ex] = answer[poll[1]][poll[0]]+1;
                    queue.offer(new int[]{ex,ey});
                    visited[ey][ex] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ans = visited[i][j] ? answer[i][j] : -1;
                System.out.print(ans+" ");
            }
            System.out.println();
        }
    }
}
