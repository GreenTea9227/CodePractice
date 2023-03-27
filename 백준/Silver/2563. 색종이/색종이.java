
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int[][] map = new int[100][100];

        for (int i = 0; i < num; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            for (int j = first; j <first+10; j++) {
                for (int k = second; k <second+10; k++) {
                    map[j][k] =1;
                }
            }

        }

        int count =0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j]==1)
                    count++;
            }
        }
        System.out.println(count);


    }
}
