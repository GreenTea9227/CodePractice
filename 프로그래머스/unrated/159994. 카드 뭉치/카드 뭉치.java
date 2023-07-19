class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        int first = 0;
        int second = 0;
        for (int i=0;i<goal.length;i++) {
            String cur = goal[i];
            if (check(first,cur,cards1)) {
                first++;
                continue;
            }
             if (check(second,cur,cards2)) {
                second++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
    
    public boolean check(int first, String cur,String[] cards) {
        return first < cards.length && cards[first].equals(cur);
    }
}