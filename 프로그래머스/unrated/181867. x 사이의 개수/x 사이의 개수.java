import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> list = new ArrayList<>();
         myString = myString+"x";
        
        int count=0;
        for (int i=0;i<myString.length();i++) {
            if (myString.charAt(i) == 'x') {
                list.add(count);
                count=0;
                continue;
            }           
            count++;
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}