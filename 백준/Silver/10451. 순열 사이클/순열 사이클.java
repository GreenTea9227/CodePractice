

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int ans =0;
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num+1];
            boolean[] visited = new boolean[num+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= num; j++) {

                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= num; j++) {

                int start = arr[j];

                if (visited[start])
                    continue;

                while (!visited[start]) {

                    visited[start] = true;
                    start = arr[start];

                }
                ans++;
            }

            System.out.println(ans);


        }
    }
}
