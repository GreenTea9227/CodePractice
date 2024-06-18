
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		String[] line = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.parseInt(line[i-1]);
		}
		dp[0]=0;

		for (int i = 2; i < dp.length; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[j] + dp[i- j],dp[i]);
			}
		}
		System.out.println(dp[dp.length-1]);
	}
}
