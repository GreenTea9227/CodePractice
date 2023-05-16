import java.util.*;

class Solution {
    
   int answer = 1;
    int[] info;
    Map<Integer, List<Integer>> map;

    public int solution(int[] infos, int[][] edges) {
        
        info = infos;
        map = new HashMap<>();
        for (int i = 0; i < infos.length; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] arr : edges) {
            map.get(arr[0]).add(arr[1]);
        }
        
        dfs(1, 0, new HashSet<>(map.get(0)));

        return answer;
    }

    void dfs(int sheep, int wolf, HashSet<Integer> set) {
        answer = Math.max(answer, sheep);
        if (sheep == wolf)
            return;

        for (int next : set) {
            HashSet<Integer> nextSet = new HashSet<>(set);
            nextSet.addAll(map.get(next));
            nextSet.remove(next);
            if (info[next] == 0) {
                dfs(sheep + 1, wolf, nextSet);
            } else {
                dfs(sheep, wolf + 1, nextSet);
            }
        }
    }
    
  
}