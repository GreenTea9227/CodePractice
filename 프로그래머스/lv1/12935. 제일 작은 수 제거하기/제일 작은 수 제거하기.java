import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int asInt = Arrays.stream(arr).min().getAsInt();
        
        return arr.length!=1 ?  Arrays.stream(arr).filter(i -> i!=asInt).toArray() : new int[]{-1};
    }
}