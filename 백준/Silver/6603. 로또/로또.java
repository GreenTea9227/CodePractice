

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            if (num == 0)
                break;

            String[] arr = new String[num];
            for (int i = 0; i < num; i++) {
                arr[i] = st.nextToken();
            }

            check = new boolean[num];
            combination(arr,0,0,"");
            System.out.println();
        }
    }

    static void combination(String[] arr,int depth,int start,String result) {

        if (depth == 6)
            System.out.println(result);

        for (int i = start; i < arr.length; i++) {
            if (!check[i]) {
                check[i] =true;
                combination(arr,depth+1,i+1,result + arr[i]+" ");
                check[i]=false;
            }
        }
    }
}
