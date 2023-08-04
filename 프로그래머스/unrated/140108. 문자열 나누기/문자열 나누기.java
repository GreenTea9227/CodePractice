class Solution {
    public int solution(String s) {
         int answer = 0;

        int first = 0;
        int second = 0;
        char fc = '*';

        for (int i = 0; i < s.length(); i++) {
            if (fc == '*')
                fc = s.charAt(i);
            
            if (fc == s.charAt(i)) {
                first++;
            } else {
                second++;
            }
            
            if (first == second) {
                answer++;
                first=0;
                second=0;
                fc = '*';
            }
        }
        
        return first != second ? answer + 1 : answer;
    }
}