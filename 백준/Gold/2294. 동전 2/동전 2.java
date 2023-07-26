
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int MAX_NUM = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] numbers = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.fill(dp, MAX_NUM);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = numbers[i]; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - numbers[i]] + 1);
            }
        }
        System.out.println(dp[k] == 100000 ? -1 : dp[k]);

    }
}
