class Solution {
    public int[] solution(int n, int m) {
        int a1 = n;
        int b1 = m;
        if (m>n) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        while (m!=0) {
           int temp = n % m;
            n = m;
            m = temp;
        }
        
        return new int[]{n,a1 * b1 / n};
    }
}