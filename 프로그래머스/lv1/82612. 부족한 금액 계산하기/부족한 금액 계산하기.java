import java.util.stream.*;

class Solution {
    public long solution(int price, int money, int count) {
        
        long ans = LongStream.rangeClosed(1,count).map(i -> i*price).sum() - money ;
        return ans >= 0 ? ans : 0 ;
    }
}