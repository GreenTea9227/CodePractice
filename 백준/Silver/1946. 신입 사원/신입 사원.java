
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Node> list = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int f1 = Integer.parseInt(st.nextToken());
                int f2 = Integer.parseInt(st.nextToken());
                list.add(new Node(f1, f2));
            }

            list.sort(Comparator.comparing(a -> a.f1));

            int ans = 0;
            int num = list.get(0).f2;
            for (int j = 1; j < list.size(); j++) {
                int f2 = list.get(j).f2;
                if (num > f2) {
                    num = f2;
                    continue;
                }
                ans++;
            }

            System.out.println(N-ans);


        }
    }

    static class Node {
        private int f1;
        private int f2;

        public Node(int f1, int f2) {
            this.f1 = f1;
            this.f2 = f2;
        }
    }
}
