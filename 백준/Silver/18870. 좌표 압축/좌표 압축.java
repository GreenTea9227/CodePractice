import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Queue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getValue)
														  .thenComparing(Node::getIndex));

		int T = sc.nextInt();
		sc.nextLine();
		int[] ans = new int[T];

		int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		for (int i = 0; i < arr.length; i++) {
			queue.offer(new Node(i, arr[i]));
		}

		int seq = 0;
		int previous = queue.peek().value;
		while (!queue.isEmpty()) {
			Node poll = queue.poll();
			if (previous != poll.value) {
				seq++;
				previous = poll.value;
			}
			ans[poll.index] = seq;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb);

	}

	static class Node {
		int value;
		int index;

		public Node(int index, int value) {
			this.index = index;
			this.value = value;
		}

		public int getIndex() {
			return index;
		}

		public int getValue() {
			return value;
		}
	}
}
