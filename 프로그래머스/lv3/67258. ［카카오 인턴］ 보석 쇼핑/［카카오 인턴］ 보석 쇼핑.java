import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
       int[] answer = new int[2];
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();

        int distance = Integer.MAX_VALUE;
        int start = 0;

        for (int i = 0; i < gems.length; i++) {
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            if (map.size() != set.size())
                continue;

            while (map.size() == set.size()) {
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) {
                    map.remove(gems[start]);
                }
                start++;
            }

            if (i - start < distance) {
                answer[0] = start;
                answer[1] = i + 1;
                distance = i - start;
            }
            
        }
        return answer;
    }
}