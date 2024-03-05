class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;     
        int wide = w*2+1;
        
        int start = 1;
        
        for (int num : stations) {
            
            int leftEnd = num - w;
            if (leftEnd > 0) {
                int len =  leftEnd - start;
                int remain = len % wide > 0 ? 1 : 0;
                answer = answer + len / wide + remain;   
            }
          
            start = num + w + 1;
        }
        
        if (stations[stations.length-1] + w + 1  <= n) {
            int len =  n + 1 - start;
            int remain = len % wide > 0 ? 1 : 0;
            answer = answer + len / wide + remain;
        }
    
        return answer;
    }
    
}