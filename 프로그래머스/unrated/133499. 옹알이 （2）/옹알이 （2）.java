import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(String[] babbling) {
       String[] strs = new String[]{"aya", "ye", "woo", "ma"};
        return (int) Arrays.stream(babbling).filter(i -> {
            for (int j = 0; j < strs.length; j++) {
                if (i.contains(strs[j].repeat(2)))
                    return false;
            }
            return true;
        }).map(i -> {
            for (int j = 0; j < strs.length; j++) {
                i = i.replace(strs[j], " ");
            }
            return i;
        }).filter(i -> i.isBlank()).count();
    }
}