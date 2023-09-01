
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();


        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = s1.charAt(i - 1) == s2.charAt(j - 1) ?
                        dp[i - 1][j - 1] + 1 : Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        System.out.println(dp[s1.length()][s2.length()]);
        System.out.println(findLCS(dp,s1, s2));

    }


    private static String findLCS(int[][] dp,String s1, String s2) {
        StringBuilder sb = new StringBuilder();

        int row = s1.length();
        int col = s2.length();

        while (row > 0 && col > 0) {
            if (dp[row][col] == dp[row-1][col]) {
                row--;
            } else if (dp[row][col] == dp[row][col-1]) {
                col--;
            } else {
                sb.append(s1.charAt(row-1));
                row--;
                col--;
            }
        }
        return sb.reverse().toString();
    }
}
