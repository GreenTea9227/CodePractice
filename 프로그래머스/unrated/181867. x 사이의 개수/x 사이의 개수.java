import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
         myString = "x"+myString+"x";
        
        int index=0;
        for (int i=1;i<myString.length();i++) {
            if (myString.charAt(i) == 'x') {
                list.add(i-index-1);
                index=i;
            }           
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}