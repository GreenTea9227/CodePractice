import java.util.*;

class Solution {
    public String solution(String s) {
        
        int slen = s.length();
        return slen %2 ==0 ? s.substring(slen/2-1,slen/2-1+2) : s.substring(slen/2,slen/2+1);
    }
}