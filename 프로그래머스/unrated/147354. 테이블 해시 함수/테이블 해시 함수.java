import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data,(a,b) ->  {
            return a[col-1] != b[col-1] ? a[col-1] - b[col-1] : b[0] - a[0];
        });
        
        return IntStream.range(row_begin-1,row_end).map(i -> 
            IntStream.range(0,data[i].length).map(j -> data[i][j]%(i+1)).sum()
        ).reduce(0, (acc, m) -> acc ^ m);
    }
}