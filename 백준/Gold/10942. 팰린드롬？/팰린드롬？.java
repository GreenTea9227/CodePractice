
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
								   .boxed().collect(Collectors.toList());
		list.add(0,0);

		int[][] dp = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++)
			dp[i][i] = 1;

		for (int i = 1; i <= N-1; i++)
			if (list.get(i).equals(list.get(i+1)))
				dp[i][i + 1] = 1;

		for (int i = 2; i < N; i++) {
			for (int j = 1; j <= N-i; j++) {
				if (list.get(j).equals(list.get(j+i)) && dp[j + 1][j + i - 1] == 1)
					dp[j][j + i] = 1;
			}
		}

		int M = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < M; i++) {
			int[] ints = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int start = ints[0];
			int end = ints[1];
			sb.append(dp[start][end]).append("\n");
		}
		System.out.println(sb);
	}
}
