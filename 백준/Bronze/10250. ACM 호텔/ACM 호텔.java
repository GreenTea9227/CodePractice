import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int N = sc.nextInt();
			int h = (N - 1) % H + 1;

			int w = (N - 1) / H + 1;
			System.out.printf("%d%02d\n", h, w);
		}
	}

}
