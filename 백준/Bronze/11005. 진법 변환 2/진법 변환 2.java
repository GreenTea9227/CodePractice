import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Arrays.stream(sc.nextLine().split(" "))
						  .reduce((first, second) -> {
								  int f = Integer.parseInt(first);
								  int s = Integer.parseInt(second);
								  return Integer.toString(f, s).toUpperCase();
							  }
						  ).ifPresent(System.out::println);
	}
}
