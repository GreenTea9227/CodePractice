

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int t = Integer.parseInt(br.readLine());
            String[] arr = new String[t];
            for (int j = 0; j < t; j++) {
                arr[j] = br.readLine();
            }

            check(arr);
        }
    }

    private static void check(String[] arr) {
        Arrays.sort(arr);

        for (int i = 0; i < arr.length-1; i++) {
            String s1 = arr[i];
            String s2 = arr[i+1];
            if (s2.startsWith(s1)) {
                System.out.println("NO");
                return;
            }

        }
        System.out.println("YES");
    }
}
