class Solution {
    public int solution(long num) {
        
        int count =0;
        while (num != 1L && count < 500) {
            
            num = num % 2==0 ? num/2 : num * 3 +1;
            count++;
            
        }
        return count >= 500 ? -1 : count;
    }
}