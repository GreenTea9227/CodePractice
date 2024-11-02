
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Integer N = Integer.parseInt(st.nextToken());
		Integer M = Integer.parseInt(st.nextToken());
		Integer T = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		Integer k = Integer.parseInt(st.nextToken());
		Integer a = Integer.parseInt(st.nextToken());
		Integer b = Integer.parseInt(st.nextToken());

		arr = new String[N];
		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < T; i++) {
			String[] second = new String[N];

			for (int j = 0; j < N; j++) {
				StringBuilder sb = new StringBuilder(arr[j]);
				for (int l = 0; l < M; l++) {

					int cnt = 0;
					cnt = countAsterisk(j, k, N, l, M, cnt);

					char cur = arr[j].charAt(l);
					if (cur == '*') {
						--cnt;
						if (cnt < a || cnt > b) {
							sb.setCharAt(l, '.');
						}
					} else {
						if (cnt > a && cnt <= b) {
							sb.setCharAt(l, '*');
						}
					}
				}
				second[j] = sb.toString();
			}

			arr = second;
		}

		for (String s : arr) {
			bw.write(s);
			bw.write("\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	private static int countAsterisk(int j, Integer k, Integer N, int l, Integer M, int cnt) {

		for (int m = Math.max(j - k, 0); m <= Math.min(j + k, N - 1); m++) {
			for (int n = Math.max(l - k, 0); n <= Math.min(l + k, M - 1); n++) {
				if (arr[m].charAt(n) == '*')
					cnt++;
			}
		}
		return cnt;
	}
}
