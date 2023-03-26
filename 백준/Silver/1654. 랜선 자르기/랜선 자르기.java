

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] s1 = s.split(" ");
        int N = Integer.parseInt(s1[0]);
        int C = Integer.parseInt(s1[1]);

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        long end = arr[arr.length - 1];
        long mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            long count = 0;

            for (int num : arr) {
                count += num / mid;
            }

            if (count < C) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println((start + end) / 2);
    }
}
