import java.util.*;

class Solution {
    boolean[] visited;
    int answer=0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k,dungeons,0);
        return answer;
    }
    
    void dfs(int k, int[][] dungeons,int count) {
        
        
        for (int i=0;i<dungeons.length;i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i]=true;
                answer = Math.max(count+1,answer);
                dfs(k-dungeons[i][1],dungeons,count+1);
                visited[i]=false;
            }
        }
    }
}