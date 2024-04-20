
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" "))
						   .mapToInt(Integer::parseInt)
						   .toArray();
		}
		dfs(0);
		System.out.println(answer);
	}

	private static void dfs(int count) {
		if (count == N) {
			int deference = logic();
			answer = Math.min(answer, deference);
			return;
		}

		visited[count] = true;
		dfs(count+1);

		visited[count] = false;
		dfs(count+1);

	}

	private static int logic() {
		int teamStart = 0;
		int teamLink = 0;

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					teamStart += arr[i][j];
					teamStart += arr[j][i];
				} else if (!visited[i] && !visited[j]) {
					teamLink += arr[i][j];
					teamLink += arr[j][i];
				}
			}
		}
		return Math.abs(teamStart - teamLink);
	}
}
