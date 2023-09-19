class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown+yellow;
        for (int bw = 1;bw<=brown;bw++) {
            int bh = total / bw;
            if ((bw-2)*(bh-2) == yellow) {
                answer[0] = bw;
                answer[1] = bh; 
            }
        }
             
        return answer;
    }
}