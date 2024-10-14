import java.util.*;
import java.util.stream.*;

class Solution {
    private Set<String> set = new HashSet<>();
    private boolean[] check = new boolean[4];
    public int solution(String[] babbling) {
        
        String[] jo = {"aya","ye","woo","ma"};
        for (int i=1;i<=4;i++) {
            combi(jo,"",0,i);
        }
        return (int)Arrays.stream(babbling).filter(s -> set.contains(s))
            .count();

    }
    
    private void combi(String[] babbling,String str, int depth,int target) {
        if (depth == target) {
            set.add(str);
            return;
        }
        
        for (int i=0;i<4;i++) {
            if (check[i]) {
                continue;
            }
            
            check[i] = true;
            combi(babbling,str+babbling[i],depth+1,target);
            check[i]=false;            
        }
        
    }
}