import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int n;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        dfs(0, 0, n, n);
        System.out.println(white);
        System.out.println(blue);
    }

    static void dfs(int x1, int y1, int x2, int y2) {

        int check = check(x1, y1, x2, y2);
        if (check ==-1) {
            int mx = (x1+x2)/2;
            int my = (y1+y2)/2;
            dfs(x1,y1,mx,my); //2
            dfs(mx,my,x2,y2); //4
            dfs(mx,y1,x2,my); //1
            dfs(x1,my,mx,y2); //3
            return;
        }

        if (check==1)
            blue++;
        else
            white++;

    }

    static int check(int x1, int y1, int x2, int y2) {

        int c = map[y1][x1];

        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[j][i] != c) {
                    return -1;
                }
            }
        }

        return c;
    }
}
