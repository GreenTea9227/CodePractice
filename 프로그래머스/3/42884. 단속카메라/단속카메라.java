import java.util.*;

class Solution {
    public int solution(int[][] routes) {
		int answer = 1;
		Arrays.sort(routes, (arr1, arr2) -> arr1[1] == arr2[1] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);
		int index = 0;
		int num = routes[0][1];
		while (index < routes.length) {

			if (routes[index][0] <= num) {
				index++;
				continue;
			}
			num = routes[index][1];
			answer++;
			index++;
		}
		return answer;
	}
}