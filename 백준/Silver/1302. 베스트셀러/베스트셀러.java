import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < T; i++) {
			String key = br.readLine();
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		String result = map.entrySet()
						   .stream()
						   .sorted(Comparator.comparing(Map.Entry<String, Integer>::getValue).reversed()
											 .thenComparing(Map.Entry::getKey))
						   .findFirst()
						   .get()
						   .getKey();  // 가장 첫 번째(가장 많이 팔린 책)를 가져옴

		System.out.println(result);
	}
}
