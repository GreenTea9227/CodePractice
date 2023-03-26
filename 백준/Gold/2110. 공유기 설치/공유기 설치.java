

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
        int c = Integer.parseInt(s1[1]);

        int[] home = new int[N];
        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(home);

        int min = 1;
        int max = home[home.length - 1] - home[0];

        int ans=0;
        while (min <= max) {
            int distance = (max + min) / 2;

            int count = 1;
            int currentHome = home[0];

            for (int i = 1; i < home.length; i++) {
                if (currentHome + distance <= home[i]) {
                    currentHome = home[i];
                    count++;
                }
            }

            if (count >= c) {
                ans = distance;
                min = distance + 1;
            } else { // count >= c;
                max = distance-1;
            }
        }

        System.out.println(ans);
    }
}
