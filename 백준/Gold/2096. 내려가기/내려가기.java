import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] maxdp = new int[3];
        int[] mindp = new int[3];
        int[] current = new int[3];
        int[] temp = new int[3];

        maxdp[0] = mindp[0] = Integer.parseInt(st.nextToken());
        maxdp[1] = mindp[1] = Integer.parseInt(st.nextToken());
        maxdp[2] = mindp[2] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                current[j] = Integer.parseInt(st.nextToken());
            }


            temp[0] = current[0] + Math.max(maxdp[1], maxdp[0]);
            temp[2] = current[2] + Math.max(maxdp[1], maxdp[2]);
            temp[1] = current[1] + Math.max(maxdp[1], Math.max(maxdp[0], maxdp[2]));
            maxdp[0] = temp[0];
            maxdp[1] = temp[1];
            maxdp[2] = temp[2];


            temp[0] = current[0] + Math.min(mindp[0], mindp[1]);
            temp[2] = current[2] + Math.min(mindp[1], mindp[2]);
            temp[1] = current[1] + Math.min(mindp[1], Math.min(mindp[0], mindp[2]));
            mindp[0] = temp[0];
            mindp[1] = temp[1];
            mindp[2] = temp[2];

        }

        System.out.println(Math.max(maxdp[0], Math.max(maxdp[1], maxdp[2])));
        System.out.println(Math.min(mindp[0], Math.min(mindp[1], mindp[2])));

    }
}
