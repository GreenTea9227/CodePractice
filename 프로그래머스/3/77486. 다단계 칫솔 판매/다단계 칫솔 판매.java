import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        
        Map<String,String> persons = new HashMap<>();
        Map<String,Integer> total = new HashMap<>();
        for (int i=0;i<enroll.length;i++) {
            persons.put(enroll[i],referral[i]);
            total.put(enroll[i],0);
        }
        
       for (int i=0;i<seller.length;i++) {
            String current = seller[i];
            int currentAmount = amount[i] * 100;
           
            while (!current.equals("-")) {
                int remain = (int)(currentAmount * 0.1);
                if (remain  < 1) {
                    total.put(current,total.get(current) + currentAmount);
                    break;
                }
                total.put(current,total.get(current) + currentAmount - remain);
                
                current = persons.get(current);
                currentAmount = remain;
            }
       }
            
        int[] answer = new int[enroll.length];
        for (int i=0;i<enroll.length;i++) {
            answer[i] = total.get(enroll[i]);
        }
        return answer;
    }
}

