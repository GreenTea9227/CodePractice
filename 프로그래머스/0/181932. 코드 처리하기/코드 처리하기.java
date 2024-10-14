class Solution {
    public String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = -1;

        for (int i = 0; i < code.length(); i++) {
            char c = code.charAt(i);

            if (c == '1') {
                mode *= -1;
            } else if ((mode == -1 && i % 2 == 0) || (mode == 1 && i % 2 == 1)) {
                sb.append(c);
            }
        }

        return sb.length() == 0 ? "EMPTY" : sb.toString();
    }
}
