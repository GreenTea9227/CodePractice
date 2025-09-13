import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] servers = new int[24];
        
        for (int i=0;i<players.length;i++) {
            int player = players[i];
            int server = servers[i];
            
            if (player < m * server) {
                continue;                
            }
            
            int addServer = player / m - server;
            for (int j=1; j<k && i+j<players.length;j++) {
                servers[i+j]+=addServer;
            }
            answer += addServer;
        }
        
        return answer;
    }
}