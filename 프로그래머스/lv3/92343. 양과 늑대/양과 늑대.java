import java.util.*;

class Solution {
    
    boolean[] visited;
    int answer = 1;
    int[] info;
    Map<Integer,List<Integer>> map;
    
    public int solution(int[] infos, int[][] edges) {

        visited = new boolean[infos.length];
        info = infos;
        map = new HashMap<>();
        
        for (int i=0;i<infos.length;i++) {
            map.put(i, new ArrayList<>());
        }
        
        for (int[] arr : edges) {
            map.get(arr[0]).add(arr[1]);
        }
        
        

        visited[0] = true;
        dfs(1, 0, new ArrayList<>(map.get(0)));

        return answer;
    }

    void dfs(int sheep, int wolf, List<Integer> list) {

        for (int i =0; i< list.size();i++ ) {

            int next = list.get(i);

            if (visited[next])
                continue;

            visited[next] = true;
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.addAll(map.get(next));
            //양
            if (info[next] == 0) {
                answer = Math.max(answer, sheep + 1);
                dfs(sheep + 1, wolf, list1);
            }
            //늑대
            if (wolf + 1 < sheep) {
                dfs(sheep, wolf + 1, new ArrayList<>(list1));
            }
            visited[next] = false;
        }
    }
    
  
}