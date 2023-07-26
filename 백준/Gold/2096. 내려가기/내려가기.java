import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[] maxdp = new int[3];
        int[] mindp = new int[3];
        st = new StringTokenizer(br.readLine());
        maxdp[0] = mindp[0] = Integer.parseInt(st.nextToken());
        maxdp[1] = mindp[1] = Integer.parseInt(st.nextToken());
        maxdp[2] = mindp[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            int f3 = Integer.parseInt(st.nextToken());

            int b0 = maxdp[0];
            int b1 = maxdp[1];
            int b2 = maxdp[2];

            int m0 = mindp[0];
            int m1 = mindp[1];
            int m2 = mindp[2];

            maxdp[0] = f1 + Math.max(b0, b1);
            maxdp[1] = f2 + Math.max(b0, Math.max(b1, b2));
            maxdp[2] = f3 + Math.max(b1, b2);

            mindp[0] = f1 + Math.min(m0,m1);
            mindp[1] = f2 + Math.min(m0, Math.min(m1, m2));
            mindp[2] = f3 + Math.min(m1, m2);

        }

        Arrays.sort(maxdp);
        Arrays.sort(mindp);
        System.out.println(maxdp[2]);
        System.out.println(mindp[0]);


    }
}
