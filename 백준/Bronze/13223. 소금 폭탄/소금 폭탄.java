
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String current = sc.nextLine();
		String target = sc.nextLine();

		int t1 = timeTranslate(current);
		int t2 = timeTranslate(target);

		t2 = t2 < t1 ? t2 + 3600 * 24 : t2;
		int cal = t2 - t1;
		if (cal == 0) {
			System.out.println("24:00:00");
			return;
		}

		int hour = cal / 3600;
		cal %= 3600;
		int minute = cal / 60;
		cal %= 60;
		int second = cal;

		System.out.printf("%02d:%02d:%02d", hour, minute, second);

	}

	private static int timeTranslate(String time) {
		String[] split = time.split(":");
		// return IntStream.rangeClosed(0, 2)
		// 				.reduce(0,(total, next) ->
		// 						 total + (int)Math.pow(60, Math.abs(next - 2)) * Integer.parseInt(split[next]));
		return Integer.parseInt(split[0]) * 3600 + Integer.parseInt(split[1]) * 60 + Integer.parseInt(split[2]);
	}
}
