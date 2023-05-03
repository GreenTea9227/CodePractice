

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> list = new ArrayList<>();
    static String next;
    static int n;
    static boolean[] used = new boolean[10];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        next = sc.nextLine().trim().replace(" ", "");

        for (int i = 0; i <= 9; i++) {
            used[i] =true;
            dfs(String.valueOf(i));
            used[i]=false;
        }

        Collections.sort(list);

        System.out.println(list.get(list.size()-1));
        System.out.println(list.get(0));


    }

    static void dfs(String str) {
        int cur = str.length();
        int num = Character.getNumericValue(str.charAt(str.length() - 1));

        if (cur == n+1) {
            list.add(str);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (used[i])
                continue;

            if ((next.charAt(cur - 1) == '<' && num < i) || (next.charAt(cur - 1) == '>' && num > i)) {
                used[i] = true;
                dfs(str + i);
                used[i] = false;
            }
        }
    }
}
