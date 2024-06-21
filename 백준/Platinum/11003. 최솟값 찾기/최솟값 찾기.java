
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		List<Integer> list = Arrays.stream(br.readLine().split(" "))
									  .map(Integer::parseInt)
									  .collect(Collectors.toList());

		list.add(0,0);

		StringBuilder sb = new StringBuilder();

		ArrayDeque<Integer> deque = new ArrayDeque<>();


		for (int i = 1; i < list.size(); i++) {

			while (!deque.isEmpty() && deque.peekLast() > list.get(i)) {
				deque.pollLast();
			}

			deque.addLast(list.get(i));

			if (i+1>L && list.get(i-L).equals(deque.peek())) {
				deque.pollFirst();
			}

			sb.append(deque.peek()).append(" ");
		}

		System.out.println(sb);

	}
}
