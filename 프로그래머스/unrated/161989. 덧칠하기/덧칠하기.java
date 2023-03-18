class Solution {
    public int solution(int n, int m, int[] section) {
            int answer = 0;
            int index = 1;
            
            boolean[] roll = new boolean[n+1];
            for (int i : section) {
                roll[i] = true;
            }
            
            while (index < n+1) {
                if (roll[index]) {
                    answer++;
                    index+=m;
                    continue;
                }
                index++;
            }
            return answer;
    }
}