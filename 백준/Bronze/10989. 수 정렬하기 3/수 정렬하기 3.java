import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		int[] arr = new int[10_001];

		for (int i = 0; i < T; i++) {
			arr[Integer.parseInt(br.readLine())]++;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr[i]; j++) {
				bw.write(i+"\n");
			}
		}

		bw.flush();
		bw.close();
	}
}
