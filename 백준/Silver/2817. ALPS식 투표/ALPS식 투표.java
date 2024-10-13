
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		double minimum = total * 0.05;

		int userCount = sc.nextInt();
		sc.nextLine();
		List<Node> users = new ArrayList<>();
		Map<String, Integer> point = new TreeMap<>();

		for (int i = 0; i < userCount; i++) {
			String[] next = sc.nextLine().split(" ");
			String name = next[0];
			int vote = Integer.parseInt(next[1]);

			if (vote < minimum)
				continue;
			point.put(name, 0);
			users.add(new Node(name, vote));
		}

		Queue<Node> queue = new PriorityQueue<>((a, b) -> (int)(b.value - a.value));

		for (Node user : users) {
			for (int i = 1; i <= 14; i++) {
				queue.offer(new Node(user.name, user.value / i));
			}
		}

		for (int i = 0; i < 14; i++) {
			Node poll = queue.poll();
			point.computeIfPresent(poll.name, (k, v) -> v + 1);
		}

		for (Map.Entry<String, Integer> entry : point.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}

	static class Node {

		String name;
		double value;

		public Node(String name, double value) {
			this.name = name;
			this.value = value;
		}
	}
}
