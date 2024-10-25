
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// Prefix sum array
		long[] sums = new long[n];
		sums[0] = arr[0];
		for (int i = 1; i < n; i++) {
			sums[i] = sums[i - 1] + arr[i];
		}

		long result = 0;
		for (int y = 1; y < n - 1; y++) {
			long stomSum = sums[n - 1] - sums[y]; // Sum from y to end

			int start = 0;
			int end = y - 1;

			if (start == end) {
				if (sums[0] < stomSum && stomSum < sums[y] - sums[0]) {
					result += 1;
				}
			} else {
				int already = 0;
				while (start <= end) {
					int mid = (start + end) / 2;

					if (sums[mid] < stomSum && stomSum < sums[y] - sums[mid]) {
						result += (mid + 1 - already);
						already = mid + 1;
						start = mid + 1;
					} else {
						end = mid - 1;
					}
				}
			}
		}

		System.out.println(result);
	}
}
