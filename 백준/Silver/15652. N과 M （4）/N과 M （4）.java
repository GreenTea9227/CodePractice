
import java.util.Scanner;

public class Main {

	static int n, m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		solve(0,1,"");
	}

	private static void solve(int depth,int start,String answer) {
		if (depth == m) {
			System.out.println(answer.trim());
			return;
		}

		for (int i = start; i <= n; i++) {
			solve(depth+1,i,answer+" "+i);
		}
	}

}
