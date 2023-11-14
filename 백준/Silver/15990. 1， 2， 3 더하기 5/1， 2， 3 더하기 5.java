

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    private static final int NUMBER = 1000000009;

    public static void main(String[] args) throws IOException {
        long[][] dp = new long[100001][4];

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i < dp.length; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % NUMBER;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % NUMBER;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % NUMBER;
        }


        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int cur = sc.nextInt();
            long num =  (dp[cur][1] + dp[cur][2] + dp[cur][3])% NUMBER;
            bw.write( num+ "\n");
        }
        bw.flush();

    }
}
