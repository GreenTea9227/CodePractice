class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int delSum = 0;
        int pickSum = 0;
        for (int i=n;i>0;i--) {
            
            delSum += deliveries[i-1];
            pickSum += pickups[i-1];
            
            
            while (delSum > 0 || pickSum > 0){
                delSum -= cap;
                pickSum -= cap;
                answer += i*2;
            }
            
        }
        
        return answer;
    }
}