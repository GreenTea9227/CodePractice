

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		long answer = N;
		for (long i = 2; i <= Math.sqrt(N); i++) {
			if (N%i == 0) {
				answer = answer - answer/i;
				while(N%i == 0) N /= i;
			}
		}
		if (N > 1)
			answer = answer - answer/N;
		System.out.println(answer);




	}
}
