
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] querys = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			querys[i] = Integer.parseInt(st.nextToken());
		}

		querys[0] = querys[1];
		for (int i = 1; i <= N; i++) {
			querys[i] = querys[i - 1] ^ querys[i];
		}

		int ans = 0;
		int s, e;
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			ans ^= querys[s-1] ^ querys[e];
		}
		System.out.println(ans);

	}
}
