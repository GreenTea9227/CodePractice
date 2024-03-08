
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	private static boolean[] visited;
	private static int[][] arr;
	private static int answer = Integer.MAX_VALUE;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}


		for (int i = 1; i <= N; i++) {
			for (int j = i; j <= N; j++) {
				if (i == j)
					continue;
				arr[i][j] += arr[j][i];
			}
		}

		combi(1, 0);
		System.out.println(answer);

	}

	private static void combi(int idx, int count) {

		if (count == N / 2) {
			diff();
			return;
		}

		for (int i = idx; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				combi(i + 1, count + 1);
				visited[i] = false;
			}
		}
	}

	private static void diff() {
		int team1 = 0;
		int team2 = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (visited[i] && visited[j]) {
					team1 += arr[i][j];
				} else if(!visited[i] && !visited[j]) {
					team2 += arr[i][j];
				}
			}
		}

		int abs = Math.abs(team1 - team2);
		if (abs == 0) {
			System.out.println(0);
			System.exit(0);
		}

		answer = Math.min(abs, answer);
	}
}
