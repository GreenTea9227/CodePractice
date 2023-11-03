
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            if (k == 1) {
                System.out.println(1+" "+1);
                continue;
            }

            findInclude(w, k);
        }

    }

    private static void findInclude(String str, int k) {
        int[] alphabet = new int[26];
        for (char c : str.toCharArray()) {
            alphabet[c - 'a']++;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < str.length(); i++) {

            char cur = str.charAt(i);
            if (alphabet[cur - 'a'] < k)
                continue;

            int count = 1;
            for (int j = i + 1; j < str.length(); j++) {
                if (cur == str.charAt(j))
                    count++;
                if (count == k) {
                    max = Math.max(max, j - i + 1);
                    min = Math.min(min, j - i + 1);
                    break;
                }
            }

        }

        if (min == Integer.MAX_VALUE || max == Integer.MIN_VALUE)
            System.out.println(-1);
        else
            System.out.println(min + " " + max);
    }


}
