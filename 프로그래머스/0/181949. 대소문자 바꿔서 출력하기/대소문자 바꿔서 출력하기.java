import java.util.*;
import java.util.stream.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine().chars()
							 .mapToObj(c -> (char) c) 
							 .map(c -> Character.isUpperCase(c)
								 ? Character.toLowerCase(c)
								 : Character.toUpperCase(c))
							 .map(String::valueOf) 
							 .collect(Collectors.joining());
		System.out.println(result);
	}
}