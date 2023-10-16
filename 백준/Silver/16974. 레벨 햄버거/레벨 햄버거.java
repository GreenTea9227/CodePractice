import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    static long[] ham;
    static long[] patty;
    static long count=0;
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long X = sc.nextLong();

        ham = new long[N+1];
        patty = new long[N+1];
        ham[0]= 1;
        patty[0] = 1;
        for (int i=1;i<=N;i++) {
            ham[i] = ham[i-1]*2 + 3;
            patty[i] = patty[i-1]*2 +1;
        }
        System.out.println(ans(N,X));

    }

    public static long ans(int level,long cur) {
        if (level == 0) {
            if (cur == 0)
                return 0;
            else
                return 1;
        }


        long mid = ham[level-1]+2;
        if (cur == 1)
            return 0;
        else if (cur == mid) {
            return patty[level-1]+1;
        } else if (cur < mid) {
            return ans(level-1,cur-1);
        } else {
            return ans(level-1,cur-ham[level-1]-2)+patty[level-1]+1;
        }
    }


}
