import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		TreeSet<String> set = new TreeSet<>(Comparator.comparing(String::length)
			.thenComparing(String::compareTo));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			set.add(br.readLine());
		}

		while (!set.isEmpty()) {
			System.out.println(set.pollFirst());
		}
	}
}
