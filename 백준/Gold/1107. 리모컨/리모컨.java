

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();

        boolean[] remote = new boolean[10];
        Arrays.fill(remote, true);

        for (int i = 0; i < T; i++) {
            int num = sc.nextInt();
            remote[num] = false;
        }

        int min = Math.abs(N - 100);

        for (int i = 0; i <= 999999; i++) {
            char[] split = String.valueOf(i).toCharArray();
            boolean flag =true;

            for (char s : split) {
                if (!remote[s-'0']) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                min = Math.min(min,Math.abs(i-N)+ split.length);
            }
        }
        System.out.println(min);


    }
}
