import java.util.Scanner;

public class Main {

	static int N;
	static int[][] arr;
	static int answer=0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		depth(0,0);
		System.out.println(answer);

	}

	private static void depth(int day,int total) {
		if (day == N) {
			answer = Math.max(answer, total);
			return;
		}
		for (int i = day; i < N; i++) {
			depth(i + arr[i][0],total+arr[i][1]);
			depth(i+1,total);
		}
	}
}
