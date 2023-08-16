
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static String check = "aeiou";
    static String[] split;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        split = sc.nextLine().split(" ");
        Arrays.sort(split);
        logic(0,0,"",0,0);
    }

    private static void logic(int depth,int count,String answer,int gather,int consonant) {
        if (count == L && gather >= 1 && consonant >= 2) {
            System.out.println(answer);
            return;
        }

        for (int i = depth; i < split.length; i++) {
            String cur = split[i];
            if (check.contains(cur)) {
                logic(i+1,count+1,answer+cur,gather+1,consonant);
            } else {
                logic(i+1,count+1,answer+cur,gather,consonant+1);
            }
        }

    }
}
