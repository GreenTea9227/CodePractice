

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());

            int num = Integer.parseInt(st.nextToken());

            dp[i] = time;

            for (int j = 0; j < num; j++) {

                int curTime = Integer.parseInt(st.nextToken());
                dp[i] = Math.max(dp[i],dp[curTime]+time);

            }
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());







    }
}
