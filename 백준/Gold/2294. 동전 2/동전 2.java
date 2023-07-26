
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Arrays.fill(dp, 100000);
        Collections.sort(list);


        for (int i = 0; i < n; i++) {
            int v = list.get(i);
            int num = 1;
            for (int j = v; j < dp.length; j += v) {
                dp[j] = Math.min(dp[j], num++);
            }

            for (int j = v; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - v]+1);
            }
        }
        System.out.println(dp[k] == 100000 ? -1 : dp[k]);

    }
}
