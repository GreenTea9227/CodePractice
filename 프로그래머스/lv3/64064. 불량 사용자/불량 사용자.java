import java.util.*;
import java.util.stream.*;

class Solution {
    String[] userId;
    String[] bannedId;
    Set<String> sets = new HashSet<>();
        
    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId =banned_id;
        dfs(0,new boolean[userId.length],"");
      
        return sets.size();
       
    }
    
    private void dfs(int depth, boolean[] visited,String ans) {
        if (depth == bannedId.length) {
            sets.add(Arrays.stream(ans.split(" ")).sorted().collect(Collectors.joining()));
            return;
        }
        
        
        for (int j=0;j<userId.length;j++) {
            if (!visited[j] && check(userId[j],bannedId[depth])) {
                visited[j] = true;
                dfs(depth+1,visited,ans+" "+userId[j]);
                visited[j] = false;
            }
        }
        
    }
    
    private boolean check(String user, String banId) {
        if (user.length() != banId.length()) 
            return false;
        
        for (int i=0;i<user.length();i++) {
            if (banId.charAt(i) == '*')
                continue;
            if (user.charAt(i) != banId.charAt(i)) 
                return false;
        }
        return true;
    }
}