class Solution {
    int[]  month = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
    String[] day = new String[]{"FRI","SAT","SUN","MON","TUE","WED","THU"};
    public String solution(int a, int b) {
        String answer = "";
        int days = b;
        for (int i=0;i<a-1;i++) {
            days += month[i];
        }
        
        return day[(days-1) % 7];
    }
}