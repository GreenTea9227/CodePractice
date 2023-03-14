import java.util.*;

class Solution {
    
    List<String> list = new ArrayList<>();
    
    public int solution(String dirs) {
        int answer = 0;
        
        String[] split = dirs.split("");
        
        int x=5,y=5;
        
        for (int i=0;i<split.length;i++) {
            String order = split[i];
            
            int nx = x;
            int ny = y;
            
            if (order.equals("U")) {
                ny+=1;
            } else if (order.equals("D")) {
                ny-=1;
            } else if (order.equals("L")) {
                nx-=1;
            } else {
                nx+=1;
            }
            
            if (nx <0 || nx>=11 || ny<0 || ny>=11 ) {
                continue;
            }
            
            String kc = x+""+y;
            String kn = nx+""+ny;
            
            String path1 = kc+kn;
            String path2 = kn+kc;
        
            if (!list.contains(path1)) {
                list.add(path1);
                list.add(path2);
                answer++;   
            } 
            
            x = nx;
            y = ny;
            
        }
        
        
        
        return answer;
        
    }
}