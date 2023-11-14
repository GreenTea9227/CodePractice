
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    private static int N, M;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        dfs(0);

        System.out.println(sb);
    }

    private static void dfs(int count)   {
        if (count == M) {
            Arrays.stream(arr).forEach(i -> sb.append(i).append(" "));
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[count] = i;
            dfs(count+1);
        }
    }
}
