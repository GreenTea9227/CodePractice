import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        final int newCol = col-1;
        Arrays.sort(data,(a,b) ->  {
            return a[newCol] != b[newCol] ? a[newCol] - b[newCol] : b[0] - a[0];
        });
        
        int cur =0;
        for (int i=row_begin-1;i<row_end;i++) {
            int m = 0;
            for (int j=0;j<data[i].length;j++) {
                m += data[i][j]%(i+1);
            }
            cur ^= m;
        }
      
        return cur;
    }
}