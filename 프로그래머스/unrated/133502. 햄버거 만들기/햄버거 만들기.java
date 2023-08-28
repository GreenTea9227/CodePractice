class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int start =0;
        int[] myarr = new int[ingredient.length+1];
        
        for (int cur : ingredient) {
            myarr[++start] = cur;
            if (start >= 4 && myarr[start] == 1 &&
                myarr[start-1] == 3 &&
                myarr[start-2] == 2 &&
                myarr[start-3] == 1) {
                
                start -= 4;
                answer++;
            }
        }
        return answer;
    }
}