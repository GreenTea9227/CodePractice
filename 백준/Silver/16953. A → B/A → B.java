
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        String A = split[0];
        String B = split[1];

        int count =0;
        while (Integer.parseInt(A) < Integer.parseInt(B)) {

            count++;
            if (B.charAt(B.length()-1) == '1') {
                B = B.substring(0,B.length()-1);
                continue;
            }

            int num = Integer.parseInt(B);
            if (num % 2 != 0) {
                System.out.println(-1);
                return;
            }
            B = String.valueOf(num /2);
        }

        if (A.equals(B)) {
            System.out.println(count+1);
            return;
        }
        System.out.println(-1);
    }


}
