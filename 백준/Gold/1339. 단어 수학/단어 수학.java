
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alpahbet = new int[26];

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            String str = list.get(i);
            for (int j = 0; j < str.length(); j++) {
                alpahbet[str.charAt(j) - 'A']+= (int) Math.pow(10, str.length()-1-j);
            }
        }

        Arrays.sort(alpahbet);

        int ans = 0;
        int alpha = 25;
        int num = 9;

        while (alpha >= 0) {
            int cur = alpahbet[alpha];
            if (cur == 0)
                break;
            ans += cur * num--;
            alpha--;
        }
        System.out.println(ans);
    }
}
