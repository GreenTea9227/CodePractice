import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static StringTokenizer st;
	private static final int LEN = 20;
	private static LinkedList<Integer> list;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			logic();
		}

	}

	private static void logic() throws IOException {
		list = new LinkedList<>();
		int[] arr = new int[LEN];
		st = new StringTokenizer(br.readLine());
		String seq = st.nextToken();
		for (int i = 0; i < LEN; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		list.add(arr[0]);

		for (int i = 1; i < LEN; i++) {
			int pos = list.size();
			for (int j = list.size() - 1; j >= 0; j--) {
				if (list.get(j) < arr[i]) {

					break;
				}
				pos--;
			}
			count += list.size() - pos;
			if (list.size() == pos)
				list.add(arr[i]);
			else
				list.add(pos, arr[i]);
		}
		System.out.println(seq + " " + count);

	}

}
