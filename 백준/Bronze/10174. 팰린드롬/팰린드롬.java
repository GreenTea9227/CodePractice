
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i=0;i<N;i++) {
            StringBuilder str = new StringBuilder(br.readLine().toLowerCase());
            StringBuilder reverse = new StringBuilder(str);

            reverse.reverse();

            System.out.println(str.compareTo(reverse) == 0 ? "Yes" : "No");

        }
    }
}
