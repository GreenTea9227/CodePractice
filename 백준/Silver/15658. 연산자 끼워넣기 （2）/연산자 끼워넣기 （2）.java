
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static List<Integer> list;
	static int[] cal;
	static int small = Integer.MAX_VALUE;
	static int big = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		cal = new int[4];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}

		for (int i = 0; i < 4; i++) {
			cal[i] = sc.nextInt();
		}

		deep(1, list.get(0));
		System.out.println(big);
		System.out.println(small);

	}

	public static void deep(int seq, int ans) {
		if (seq >= list.size()) {
			small = Math.min(ans, small);
			big = Math.max(ans, big);
			return;
		}

		int cur = list.get(seq);
		for (int i = 0; i < 4; i++) {
			if (cal[i] <= 0)
				continue;

			cal[i]--;
			switch (i) {
				case 0 -> deep(seq + 1, cur + ans);
				case 1 -> deep(seq + 1, ans - cur);
				case 2 -> deep(seq + 1, cur * ans);
				case 3 -> {
					if (ans < 0) {
						deep(seq + 1, -1 * Math.abs(ans) / cur);
					} else {
						deep(seq + 1, ans / cur);
					}
				}
			}
			cal[i]++;

		}

	}
}
