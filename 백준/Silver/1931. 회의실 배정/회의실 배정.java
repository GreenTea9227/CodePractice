
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());
		Queue<Node> queue = new PriorityQueue<Node>(
			Comparator.comparing((Node n) -> n.end)
				.thenComparing((Node n) -> n.start)
		);
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			queue.offer(new Node(start, end));
		}

		int cur = -1;
		int count = 0;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (cur > node.start) {
				continue;
			}
			if (node.start == node.end) {
				cur = node.end;
				count++;
				continue;
			}

			count++;
			// System.out.println(node.start +"~"+node.end);
			cur = node.end;
		}
		System.out.println(count);
	}

	static class Node {
		int start;
		int end;

		public Node(int start, int end) {
			this.end = end;
			this.start = start;
		}
	}
}
