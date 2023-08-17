
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, R;

    static int[] y = new int[]{0, 1, 0, -1};
    static int[] x = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int group = Math.min(N, M) / 2;
        rotate(group);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }


    private static void rotate(int group) {
        for (int k = 0; k < R; k++) {
            for (int i = 0; i < group; i++) {
                int cx = i;
                int cy = i;
                int lastValue = map[cy][cx];
                int direct = 0;

                while (direct < 4) {

                    int px = cx + x[direct];
                    int py = cy + y[direct];

                    if (px >= i && px < M-i && py >= i && py < N-i) {
                        map[cy][cx] = map[py][px];
                        cx = px;
                        cy = py;
                    } else {
                        direct++;
                    }

                }

                map[cy+1][cx] = lastValue;
            }
        }

    }

}
