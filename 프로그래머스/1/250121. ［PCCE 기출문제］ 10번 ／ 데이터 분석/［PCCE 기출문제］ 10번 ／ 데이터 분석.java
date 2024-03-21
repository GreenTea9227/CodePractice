import java.util.Arrays;
import java.util.HashMap;

class Solution {

	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {

		HashMap<String, Integer> hashMap = new HashMap<>();
		hashMap.put("code", 0);
		hashMap.put("date", 1);
		hashMap.put("maximum", 2);
		hashMap.put("remain", 3);

		return Arrays.stream(data).filter(i -> i[hashMap.get(ext)] < val_ext)
					 .sorted((a, b) -> a[hashMap.get(sort_by)] - b[hashMap.get(sort_by)])
					 .toArray(int[][]::new);

	}

}