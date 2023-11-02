
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;



        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            arr[i][0]=n1;
            arr[i][1]=n2;
        }

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 0; j < N; j++) {
                if (i==j)
                    continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1])
                    count++;
            }
            arr[i][2] = count;
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i][2]+" ");
        }
    }

}
