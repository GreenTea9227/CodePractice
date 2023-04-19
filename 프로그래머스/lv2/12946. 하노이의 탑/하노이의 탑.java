import java.util.*;
import java.util.stream.*;

class Solution {
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = {};
        
        hanoi(n,1,3,2);
       
        return  list.stream().map(i -> i).toArray(int[][]::new);
    }
    
    public void hanoi(int count, int from , int to,int empty) {
        
        if (count == 1) {
            list.add(new int[]{from,to});
            return;
        } 
        
        
        hanoi(count-1,from,empty,to);
        hanoi(1,from,to,empty);
        hanoi(count-1,empty , to ,from);
        
    }
    
}