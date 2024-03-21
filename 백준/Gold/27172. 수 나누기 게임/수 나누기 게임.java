
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static final int MAX_NUM = 1000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];

		int[][] full = new int[MAX_NUM][2];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			full[arr[i]][0] = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			for (int j = num * 2; j < MAX_NUM; j += num) {
				if (full[j][0] == 1) {
					full[j][1] -= 1;
					full[num][1] += 1;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			bw.write(full[arr[i]][1] + " ");
		}
		bw.flush();
		bw.close();

	}
}
