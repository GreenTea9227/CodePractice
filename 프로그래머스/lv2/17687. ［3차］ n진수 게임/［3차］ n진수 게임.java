class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        p--;
        int i = 0;
        while (t > 0) {
            while (p >= sb.length()) {
                sb.append(Integer.toString(i++, n).toUpperCase());
            }
            answer.append(sb.charAt(p));
            p+=m;
            t--;
        }
        return answer.toString();
    }
}