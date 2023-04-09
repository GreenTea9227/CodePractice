import java.util.stream.*;

class Solution {
    public int solution(int left, int right) {
        
        return IntStream.rangeClosed(left,right).map(i -> {
            return IntStream.rangeClosed(1,i).filter(a -> i%a==0).count() %2 ==0 ? i : -i;
        }).sum();
        
    }
}