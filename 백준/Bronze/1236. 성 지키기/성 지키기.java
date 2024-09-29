
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		int[] ans = new int[2];
		String[] arr = IntStream.range(0, N)
								  .mapToObj(i -> sc.nextLine())
								  .toArray(String[]::new);
		
		for (int i = 0; i < N; i++) {
			if (!arr[i].contains("X"))
				ans[0]++;
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[j].charAt(i) == 'X') {
					break;
				}
				if (j==N-1 && arr[j].charAt(i) == '.') {
					ans[1]++;
				}
			}
		}

		System.out.println(Math.max(ans[0], ans[1]));



	}
}
