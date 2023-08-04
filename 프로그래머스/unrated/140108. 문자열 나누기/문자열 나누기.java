class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 1) {
            int first = 1;
            int second = 0;
            char fs = sb.charAt(0);
            for (int i=1;i<sb.length();i++) {

                if (sb.charAt(i) == fs) {
                    first++;
                } else {
                    second++;
                }

                if (first == second) {
                    sb.delete(0, i+1);
                    answer++;
                    break;
                }
            }
            if (first != second) {
                answer++;
                break;
            }
        }

        return sb.length() == 1 ? answer+1 : answer;
    }
    
    
}