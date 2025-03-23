import java.util.*;

class Solution {
    public int solution(String dirs) {

        Map<Character,int[]> map = new HashMap<>();
        map.put('L',new int[]{-1,0});
        map.put('U',new int[]{0,1});
        map.put('R',new int[]{1,0});
        map.put('D',new int[]{0,-1});
        
        
        Set<String> set = new HashSet<>();
        
        
        int cx = 0;
        int cy = 0;
        
        char[] charArr = dirs.toCharArray();
        for (char c : charArr) {
            int[] dxy = map.get(c);
            int nx = cx + dxy[0];
            int ny = cy + dxy[1];
            if (!check(nx,ny)) {
                continue;
            }
            
            set.add(""+cx+cy+nx+ny);
            set.add(""+nx+ny+cx+cy);
            cx = nx;
            cy = ny;
            
        }
        
        return set.size()/2;
    }
    
    private boolean check(int x, int y) {
        return -5 <= x && x <= 5 && -5<=y && y<=5;
    }
}