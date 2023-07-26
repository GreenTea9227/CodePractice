
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        ans = Math.max(find(list),ans);
        Collections.reverse(list);
        ans = Math.max(find(list),ans);
        System.out.println(ans);

    }

    public static int find(List<Integer> list) {
        int count = 1;
        int max = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                max = Math.max(max, count);
                count = 1;
                continue;
            }
            count++;
        }
        return Math.max(max, count);
    }
}

