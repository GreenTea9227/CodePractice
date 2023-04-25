
import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<String> answer = new ArrayList<>();
       String str = s.substring(2,s.length()-2);
        
        String[] a = str.split("\\},\\{");
        
        Arrays.sort(a,(c,b)-> c.length()-b.length());
        
        
        
        for (int i=0;i<a.length;i++) {
            String[] cur = a[i].split(",");
            for (int j=0;j<cur.length;j++) {
                if (answer.contains(cur[j]))
                    continue;
                answer.add(cur[j]);
                break;
            }
        }
        
        return answer.stream().mapToInt(Integer::parseInt).toArray();
    }
}