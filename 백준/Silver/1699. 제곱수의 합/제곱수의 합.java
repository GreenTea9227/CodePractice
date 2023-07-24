import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        int[] dp = new int[100001];

        for (int i = 1; i <= number; i++) {
            dp[i] = i;
        }

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i],dp[i - j*j]+1);
            }
        }

        System.out.println(dp[number]);
    }
}
