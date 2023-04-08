import java.util.*;

class Solution {
    
    List<String> answer = new ArrayList<>();
    Map<String,Integer> map = new HashMap<>();
    
    
    public String[] solution(String[] orders, int[] course) {
      
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = String.valueOf(arr);
        }

       
        for (int c : course) {
            for(String order: orders) {
                combi("",order,c);
            }
            
           if (!map.isEmpty()) {
                    int max = Collections.max(map.values());
                    if (max >1)
                        map.keySet().stream().filter(i -> map.get(i) == max).forEach(i -> answer.add(i));
                }
            map.clear();
 
        }
        
        String[] str = answer.toArray(new String[0]);
        Arrays.sort(str);
        
        return str;
    }
    
    public void combi(String result , String order , int count) {
        
        if (count ==0) {
            map.put(result,map.getOrDefault(result,0)+1);
            return;
        }
        
        for (int i=0;i<order.length();i++) {
            combi(result + order.charAt(i),order.substring(i+1),count-1);
        }
    }
}