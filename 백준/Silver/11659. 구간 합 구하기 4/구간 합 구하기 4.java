
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int num = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] arr = new int[num+1];

        
        StringTokenizer st2 = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(st2.nextToken()) +arr[i-1];
        }
        

        for (int i=0; i<count;i++) {
            StringTokenizer st3 = new StringTokenizer(bf.readLine());
            int first = Integer.parseInt(st3.nextToken());
            int second = Integer.parseInt(st3.nextToken());
            System.out.println(arr[second]-arr[first-1]);
        }






    }


}
