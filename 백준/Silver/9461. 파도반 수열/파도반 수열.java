import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] arr = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        for (int i = 5; i < arr.length; i++) {
            arr[i] = arr[i-1] + arr[i-5];
        }
        for (int i = 0; i < T; i++) {
            int v = sc.nextInt();
            System.out.println(arr[v]);
        }
    }
}
