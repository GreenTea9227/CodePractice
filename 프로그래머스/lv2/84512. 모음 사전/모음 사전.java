import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    
    public int solution(String word) {
        dfs("");
        return list.indexOf(word);
 
    }
    
    void dfs(String str) {

        if (str.length() > 5) {
            return;
        }
        
        list.add(str);
        
        for (int i=0; i < 5; i++) {
            dfs(str + "AEIOU".charAt(i));
        }
        
        
    }
}