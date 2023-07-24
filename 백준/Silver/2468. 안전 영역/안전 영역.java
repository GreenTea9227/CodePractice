
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] checkMap;
    static int[] mx = new int[]{0, 0, 1, -1};
    static int[] my = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
                max = Math.max(v, max);
            }
        }


        int ans = 0;
        for (int height = 0; height <= max; height++) {

            checkMap =  new boolean[N][N];
            int count =0;

            for(int j=0; j<N; j++) {
                for(int k=0; k<N; k++) {
                    if( !checkMap[j][k] && map[j][k] > height) {
                        count += dfs(k, j, height);
                    }
                }
            }
            ans = Math.max(ans, count);
        }

        System.out.println(ans);
    }

    private static int dfs(int x, int y, int findNum) {
       checkMap[y][x] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + mx[k];
            int ny = y + my[k];
            if ( nx >= 0 && nx < N && ny >= 0 && ny < N && !checkMap[ny][nx] && map[ny][nx] > findNum) {
                dfs(nx,ny,findNum);
            }
        }
        return 1;
    }
}
