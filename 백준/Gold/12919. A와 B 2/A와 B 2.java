
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static String start;
    static int flag = 0;
    static int[] alpah = new int[2];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        start = sc.nextLine();
        String second = sc.nextLine();


        System.out.println(logic(second));

    }

    public static int logic(String second) {
        if (second.length() == start.length()) {
            if (second.equals(start))
                return 1;
            return 0;
        }

        int a =0;

        if (second.charAt(0) == 'B') {
            String substring = second.substring(1);
            String string = new StringBuilder(substring).reverse().toString();
            a += logic(string);
        }

        if (second.charAt(second.length()-1)=='A') {
            a+= logic(second.substring(0,second.length()-1));
        }

        return a > 0 ? 1 : 0;



    }

}
