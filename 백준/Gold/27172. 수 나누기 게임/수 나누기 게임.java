import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int MAX_NUM = 1;

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			MAX_NUM = Math.max(arr[i], MAX_NUM);
		}

		int[][] full = new int[MAX_NUM+1][2];
		for (int i : arr) {
			full[i][0] = 1;
		}

		for (int num : arr) {
			for (int j = num * 2; j < full.length; j += num) {
				if (full[j][0] == 1) {
					full[j][1] -= 1;
					full[num][1] += 1;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int j : arr) {
			sb.append(full[j][1]).append(" ");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}
