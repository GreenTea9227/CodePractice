import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] arr;
	private static boolean[][] visited;
	private static int N, k;
	private static int time = 1;
	private static Queue<Node> queue;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[2][N + 1];

		for (int i = 0; i < 2; i++) {
			String[] split = br.readLine().split("");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(split[j - 1]);
			}
		}

		queue = new ArrayDeque<>();
		queue.offer(new Node(0, 1));

		visited = new boolean[2][N + 1];
		visited[0][1] = true;

		while (!queue.isEmpty()) {
			for (int i = 0; i < queue.size(); i++) {
				Node current = queue.poll();
				if (current.seq+k > N) {
					System.out.println(1);
					return;
				}
				check(current.seq + 1, current.line);
				check(current.seq - 1, current.line);
				check(current.seq + k, (current.line + 1) % 2);
			}

			time++;
		}
		System.out.println(0);

	}

	private static void check(int next, int line) {
		if (next <= time || visited[line][next] || arr[line][next] == 0)
			return;

		visited[line][next] = true;
		queue.offer(new Node(line, next));
	}

	private static class Node {
		int line;
		int seq;

		public Node(int line, int seq) {
			this.line = line;
			this.seq = seq;
		}
	}
}
