import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize ==0) {
            return cities.length * 5;
        }
        int time = 0;
        Deque<String> list = new ArrayDeque<>();
       
        
        for (int i=0;i<cities.length;i++) {
            String cur = cities[i].toUpperCase();
            if (list.contains(cur)) {
                list.remove(cur);
                list.addFirst(cur);
                time+=1;
                continue;
            }
            
           
             list.addFirst(cur);
             time+=5;
            if (list.size() > cacheSize) { 
                list.removeLast();
            }
        }
        
        return time;
    }
}