import java.util.Scanner;

public class Main {

    static int n;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[][] map = new int[n][n];

        back(0, 0, 0, map);
        System.out.println(count);
    }

    static void back(int row, int col, int queen, int[][] map) {

        if (row >= n) {
            if (queen == n) {
                count++;
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(row, i, map)) {
                map[row][i] = 1;
                back(row + 1, i, queen + 1, map);
                map[row][i] = 0;
            }
        }
    }

    static int[] nx = {-1, -1, 1, 1};
    static int[] ny = {-1, 1, -1, 1};

    static boolean check(int row, int col, int[][] map) {
        for (int i = 0; i < n; i++) {
            if (map[row][i] == 1 || map[i][col] == 1)
                return false;
        }// 행렬체크

        for (int i = 0; i < 4; i++) {
            if (!secondCheck(row, col, nx[i], ny[i], map))
                return false;
        }//대각선체크

        return true;
    }

    static boolean secondCheck(int row, int col, int nx, int ny, int[][] map) {
        if (row >= n || row < 0 || col < 0 || col >= n) {
            return true;
        }
        if (map[row][col] == 1)
            return false;

        return secondCheck(row + nx, col + ny, nx, ny, map);
    }
}
