import java.util.stream.*;

class Solution {
    public int[] solution(int[] array) {
       return IntStream.range(0,array.length)
           .mapToObj(i -> new int[]{array[i],i})
           .reduce((a,b) -> a[0] > b[0] ? a: b)
           .orElse(null);
    }
}