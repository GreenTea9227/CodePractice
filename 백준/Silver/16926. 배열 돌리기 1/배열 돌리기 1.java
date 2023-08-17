
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N, M, R;

    static int[] x = new int[]{0, 1, 0, -1};
    static int[] y = new int[]{1, 0, -1, 0};

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
        start();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static void start() {

        for (int i = 0; i < R ; i++) {
            boolean[][] check = new boolean[N][M];
            int[][] newArr = new int[N][M];
            rotate(check, newArr);
            map = newArr;
        }


    }



    private static void rotate(boolean[][] check, int[][] newArr) {
        for (int i = 0, j = 0; i < N && j < M; i++, j++) {
            if (!check[i][j]) {
                int cx = j;
                int cy = i;
                for (int k = 0; k < 4; k++) {
                    int px = x[k];
                    int py = y[k];
                    while (cx+px >= 0 && cx+px < M && cy+py >= 0 && cy+py < N && !check[cy+py][cx+px]){
                        newArr[cy+py][cx+px]=map[cy][cx];
                        check[cy+py][cx+px]=true;
                        cy = cy+py;
                        cx = cx+px;
                    }
                }
            }
        }
    }

}
