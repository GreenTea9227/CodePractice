import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			char change = Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
			sb.append(change);
		}

		System.out.println(sb);


	}
}
