import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        
        return 45 - Arrays.stream(numbers).distinct().sum();
    }
}