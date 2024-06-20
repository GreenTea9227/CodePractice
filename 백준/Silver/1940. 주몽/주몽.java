
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
		int start = 0;
		int end = N-1;
		int count = 0;
		while (start <  end) {
			int sum = arr[start] + arr[end];
			if (sum == M) {
				count++;
				start++;
			} else if (sum >M) {
				end--;
			} else  {
				start++;
			}
		}
		System.out.println(count);
	}
}
