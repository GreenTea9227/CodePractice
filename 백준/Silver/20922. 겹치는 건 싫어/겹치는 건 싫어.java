
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(st.nextToken());
        }

        int[] check = new int[100001];
        int left = 0;
        int right = 0;

        while (right < N) {
            while (right < N && check[ints[right]] + 1 <= K) {
                check[ints[right]]++;
                right++;
            }

            answer = Math.max(right - left, answer);
            check[ints[left]]--;
            left++;

        }
        System.out.println(answer);

    }
}
