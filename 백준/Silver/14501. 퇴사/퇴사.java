

import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int answer = depth(0, 0);
		System.out.println(answer);

	}

	private static int depth(int day, int total) {
		if (day == N) {
			return total;
		}
		int ans = 0;
		for (int i = day; i < N; i++) {
			int t1 = depth(i + arr[i][0], total + arr[i][1]);
			int t2 = depth(i + 1, total);
			ans = Math.max(ans, Math.max(t1, t2));
		}

		return ans;
	}
}
