import java.util.*;
import java.util.stream.*;

class Solution {
    Map<String,Integer> map;
    public int[] solution(String today, String[] terms, String[] privacies) {
  
        map = new HashMap<>();
        for (String strs : terms) {
            String[] s = strs.split(" ");
            map.put(s[0],Integer.parseInt(s[1]));
        }
        
        List<Integer> answer = new ArrayList<>();
        int cur = time(today);
        
        for (int i=0;i<privacies.length;i++) {
            String[] s = privacies[i].split(" ");
            int check = time(s[0])+map.get(s[1])*28;
            if (cur >= check) {
                answer.add(i+1);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
    

    private int time(String str) {
        String[] arr = str.split("\\.");
        int year = Integer.parseInt(arr[0].substring(2));
        int month = Integer.parseInt(arr[1])-1;
        int day = Integer.parseInt(arr[2]);
        
        return year*336 + month * 28 + day;
    }
}