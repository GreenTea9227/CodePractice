
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		int[] check = new int[26];
		char[] chars = new char[N];

		int cur = 0;
		int K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);

			cur = (cur + S) % N;
			int checkAlpha = c - 'A';

			if (check[checkAlpha] == 0) {
				check[checkAlpha] = cur;
			}

			if (check[checkAlpha] != cur || chars[cur] != 0 && chars[cur] != c) {
				System.out.println("!");
				return;
			}

			chars[cur] = c;
		}

		for (int i = 0; i < N; i++) {
			char current = (int)chars[cur] == 0 ? '?' : chars[cur];
			System.out.print(current);
			cur--;
			if (cur < 0)
				cur = N - 1;
		}

	}

}
