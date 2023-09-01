import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long answer = 0;
            int cur = arr[N-1];

            for (int j = N-1; j >= 0 ; j--) {
                if (arr[j] <= cur) {
                    answer += cur - arr[j];
                } else {
                    cur = arr[j];
                }
            }
            System.out.println(answer);
        }
    }
}
