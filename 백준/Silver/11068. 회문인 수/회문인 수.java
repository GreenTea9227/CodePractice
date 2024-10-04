import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		IntStream.range(0, T).forEach(i -> radixIsPalindrome(sc.nextInt()));
	}

	private static void radixIsPalindrome(int num) {
		boolean isExist = IntStream.rangeClosed(2, 64)
								   .mapToObj(radix -> exchangeRadix(num, radix))
								   .anyMatch(Main::isPalindrome);
		System.out.println(isExist ? "1" : "0");
	}

	private static String exchangeRadix(int num, int radix) {
		StringBuilder sb = new StringBuilder();
		while (num > 0) {
			if (num % radix < 10) {
				sb.append(num % radix);
			} else {
				sb.append((char)(num % radix - 10 + 'A'));
			}
			num /= radix;
		}
		return sb.toString();
	}

	private static boolean isPalindrome(String str) {
		return IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i));
	}
}
