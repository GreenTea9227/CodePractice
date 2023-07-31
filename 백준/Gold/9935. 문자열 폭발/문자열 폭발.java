
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String bomb = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() < bomb.length()) {
                continue;
            }

            if (check(bomb, sb)) {
                sb.delete(sb.length() - bomb.length(), sb.length());
            }
        }

        System.out.println(sb.isEmpty() ? "FRULA" : sb);
    }

    private static boolean check(String bomb, StringBuilder sb) {
        for (int j = 0; j < bomb.length(); j++) {
            char c1 = sb.charAt(sb.length() - bomb.length() + j);
            char c2 = bomb.charAt(j);
            if (c1 != c2) {
               return false;
            }
        }
        return true;
    }


}
