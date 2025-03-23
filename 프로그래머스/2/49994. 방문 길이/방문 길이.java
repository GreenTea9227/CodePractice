import java.util.*;

class Solution {
    public int solution(String dirs) {

        Map<Character,int[]> map = new HashMap<>();
        map.put('L',new int[]{-1,0});
        map.put('U',new int[]{0,1});
        map.put('R',new int[]{1,0});
        map.put('D',new int[]{0,-1});
        
        // 경로 등록
        Set<String> set = new HashSet<>();
        
        // 시작 0,0
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
            
            // 통과 시 경로 등록(한 쪽만 등록하면 반대편이 문제가 됨)
            set.add(""+cx+cy+nx+ny);
            set.add(""+nx+ny+cx+cy);
            cx = nx;
            cy = ny;
        }
        
        // 양방향을 등록하였으므로 2로 나누기
        return set.size()/2;
    }
    
    // 범위 체크
    private boolean check(int x, int y) {
        return -5 <= x && x <= 5 && -5<=y && y<=5;
    }
}