import java.util.*;

public class Solution {
    public int solution(int n) {
        int count=0;
        while (n>=1) {
            if (n%2 ==0)
                n/=2;
            else {
                n = (n-1)/2;
                count++;
            }
        }
        return count ;
    }
}