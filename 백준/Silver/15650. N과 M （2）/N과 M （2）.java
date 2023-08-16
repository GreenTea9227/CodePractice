import java.util.Scanner;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        dfs(1,0, "");
    }

    static void dfs(int depth,int count, String str) {
        if (count == M) {
            System.out.println(str.trim());
            return;
        }

        for (int i = depth; i <= N; i++) {
            dfs(i + 1, count+1,str + " " + i);
        }
    }
}
