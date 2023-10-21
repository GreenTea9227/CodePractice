
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] nx = new int[]{1, 0, -1, 0, 0, 0};
    static int[] ny = new int[]{0, 1, 0, -1, 0, 0};
    static int[] nz = new int[]{0, 0, 0, 0, -1, 1};
    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] tomato = new int[H][N][M];
        Queue<int[]> queue = new LinkedList<>();


        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int current = Integer.parseInt(st.nextToken());
                    tomato[i][j][k] = current;
                    if (current == 1)
                        queue.offer(new int[]{i, j, k});
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int h = poll[0]; //z
            int y = poll[1]; //y
            int x = poll[2]; //x
            for (int u = 0; u < 6; u++) {
                int hh = h + nz[u];
                int xx = x + nx[u];
                int yy = y + ny[u];
                if (checkRange(hh, xx, yy) && tomato[hh][yy][xx] == 0) {
                    tomato[hh][yy][xx] = tomato[h][y][x] + 1;
                    queue.offer(new int[]{hh, yy, xx});
                }
            }
        }

        System.out.println(checkArray(tomato));


    }

    private static boolean checkRange(int h, int x, int y) {
        return h >= 0 && x >= 0 && y >= 0 && h < H && y < N && x < M;
    }

    private static int checkArray(int[][][] arr) {
        int ans = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0)
                        return -1;
                    ans = Math.max(arr[i][j][k],ans);
                }
            }
        }
        return ans-1;
    }
}
