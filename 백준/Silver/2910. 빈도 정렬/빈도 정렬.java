import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		Map<Integer,Integer> map =new HashMap<>();
		Map<Integer,Integer> count =new HashMap<>();

		for (int i = 0; i < N; i++) {
			int cur = sc.nextInt();
			map.putIfAbsent(cur,i);
			count.put(cur,count.getOrDefault(cur,0) + 1);
		}

		count.entrySet().stream()
			 .sorted(Comparator.comparing((Map.Entry<Integer, Integer> entry) -> entry.getValue()).reversed()
						   .thenComparing(entry -> map.get(entry.getKey())))
			.forEach(node -> System.out.print("%d ".formatted(node.getKey()).repeat(node.getValue())));
	}
}
