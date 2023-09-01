
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int zero = 0;
        int one = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                zero++;
            else
                one++;
        }
        zero /= 2;
        one /= 2;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '1' && one > 0) {
                one--;
                continue;
            }
            sb.append(c);
        }
        str = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        for (int i = str.length()-1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '0' && zero > 0) {
                zero--;
                continue;
            }
            sb2.append(c);
        }
        System.out.println(sb2.reverse().toString());
    }
}
