class Solution {
    public String solution(String s, String skip, int index) {
       StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            int count = 0;
            while (count < index) {
                cur++;
                if (cur > 'z')
                    cur -=26;
                if (skip.contains(String.valueOf(cur)))
                    continue;
                count++;
            }
            sb.append(cur);
        }
        return sb.toString();
    }
}