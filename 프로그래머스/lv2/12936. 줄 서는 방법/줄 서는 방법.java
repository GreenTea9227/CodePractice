import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long total =1;
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            list.add(i);
            total*=i;
        }
        k--;
        int index = 0;
        
        while (n > 0) {
            total /= n;
            int num = (int)(k/total);
            answer[index++] = list.get(num);
            list.remove(num);
            k %= total;
            n--;
        }
        return answer;
    }   
    
}