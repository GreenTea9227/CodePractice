import java.io.*;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int[] arr = Arrays.stream((br.readLine().split(" ")))
							  .mapToInt(Integer::parseInt)
							  .filter(j -> j % 2 == 0)
							  .sorted()
							  .toArray();

			System.out.println(Arrays.stream(arr).sum() + " " + arr[0]);
		}
	}
}
