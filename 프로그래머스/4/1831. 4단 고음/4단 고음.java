

class Solution {
    private int answer = 0;
    
    public int solution(int n) {
        dfs(n-2,2);
        return answer;
    }
    
    private void dfs(int num, int plus) {
        if (num < 3 ||  Math.pow(3,plus/2) > num) {
            return;
        }
   
        if (num == 3 && plus == 2) {
            answer += 1;
            return;
        }
        
        if (num % 3==0 && plus >= 2)
            dfs(num/3,plus-2);
        dfs(num-1,plus+1);
    }
}