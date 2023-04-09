import java.util.stream.*;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
      
       
        return  IntStream.rangeClosed(0,signs.length-1).map(i -> {
            return !signs[i] ? -absolutes[i]: absolutes[i];
        }).sum();
    }
}