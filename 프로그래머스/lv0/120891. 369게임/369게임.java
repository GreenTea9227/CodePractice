import java.util.*;

class Solution {
    public int solution(int order) {
      return (int)Arrays.stream(String.valueOf(order).split("")).filter(c -> {
            return c.equals("3") || c.equals("6") || c.equals("9");
        }).count();
        
    }
}