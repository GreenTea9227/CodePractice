import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = arr[0];
        left[0] = arr[0];
        for (int i = 1; i < left.length; i++) {
            left[i] = Math.max(left[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer,left[i]);
        }

        right[right.length - 1] = arr[arr.length - 1];
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1] + arr[i], arr[i]);
        }


        for (int i = 1; i < arr.length - 1; i++) {
            answer = Math.max(left[i - 1] + right[i + 1], answer);
        }

        System.out.println(answer);
    }
}
