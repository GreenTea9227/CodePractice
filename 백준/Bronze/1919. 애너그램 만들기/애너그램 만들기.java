import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] alpha = new int[26];

		sc.nextLine().chars().forEach(c -> alpha[c - 'a']++);
		sc.nextLine().chars().forEach(c -> alpha[c - 'a']--);
		int sum = IntStream.of(alpha).map(Math::abs).sum();
		System.out.println(sum);

	}
}
