
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Character key = sc.nextLine().chars()
						  .mapToObj(c -> (char)Character.toUpperCase(c))
						  .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
						  .entrySet().stream()
						  .sorted((a, b) -> (int)(b.getValue() - a.getValue()))
						  .limit(2)
						  .reduce((first, second) -> Long.compare(first.getValue(), second.getValue()) != 0 ? first :
							  Map.entry('?', 0L))
						  .get()
						  .getKey();

		System.out.println(key);

	}
}
