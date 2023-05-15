import java.util.*;

class Solution {
    String[] strs = new String[]{"A", "E", "I", "O", "U"};
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        int answer = 0;
        dfs("");
        Collections.sort(list);
        return list.indexOf(word)+1;
 
    }
    
    void dfs(String str) {

        if (str.length() == 5) {
            return;
        }
        
        for (int i=0;i<5;i++) {
            String newStr = str+strs[i];
            list.add(newStr);
            dfs(newStr);
        }
        
        
    }
}