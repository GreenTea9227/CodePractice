
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		boolean[] arr = new boolean[1_000_001];
		for (int i = 0; i < n; i++) {
			arr[Integer.parseInt(st.nextToken())] = true;
		}
		int target = Integer.parseInt(br.readLine());
		long count = IntStream.range(0, arr.length)
							  .filter(i -> target - i <= 1_000_000 && target - i >=0 && arr[i] && arr[target - i])
							  .count();

		System.out.println(count / 2);
	}
}
