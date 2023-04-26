
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Integer>[] arr;
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        int T = sc.nextInt();

        arr = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            arr[first].add(second);
            arr[second].add(first);
        }

        dfs(start, end, 0, new boolean[n + 1]);

        System.out.println(ans);
    }

    public static void dfs(int current, int end, int count, boolean[] visited) {
        if (current == end) {
            ans = count;
            return;
        }

        for (int next : arr[current]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next, end, count + 1, visited);
                visited[next] = false;
            }
        }
    }

}
