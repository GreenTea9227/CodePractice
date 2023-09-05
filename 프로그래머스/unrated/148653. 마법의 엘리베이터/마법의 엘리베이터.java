import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer =0;
        int len = 9;
        int[] numbers = new int[10];
        while (storey > 0) {
            numbers[len--] = storey%10;
            storey /=10;
        }
        
       for (int i=numbers.length-1;i >= 1;i--) {
           if (numbers[i] > 5 || numbers[i]==5 && numbers[i-1]>=5) {
               numbers[i-1]++;
               answer += 10 - numbers[i];
           } else {
               answer += numbers[i];
           }
       }
        return answer;
    }
    
    //2222
}