class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        if (a ==1) {
            return n * b;
        }
        while (n >= a && n > 1) {
            int emptyBottle = n / a;
            int remain = n % a;
            n = remain == 0 ? emptyBottle * b: emptyBottle * b + remain;
            answer += emptyBottle * b;
        }
        return answer;
    }
}