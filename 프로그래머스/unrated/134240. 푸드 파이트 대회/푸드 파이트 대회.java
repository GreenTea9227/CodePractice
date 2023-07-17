class Solution {
    public String solution(int[] food) {
       StringBuilder sb = new StringBuilder();
        for (int i=1;i<food.length;i++) {
            int num = food[i] / 2;
            sb.append(String.valueOf(i).repeat(num));
        }
        
       StringBuilder sb2 = new StringBuilder(sb);
        sb.append("0").append(sb2.reverse());
        return sb.toString();
    }
}