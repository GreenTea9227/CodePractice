class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown+yellow;
        
        for (int i=3;i<=total/3;i++) {
            if (total % i != 0)
                continue;
            
            if (check(i,total/i,brown,yellow)) {
                return new int[]{total/i,i};
            }
        }
        return new int[]{};
    }
    
    private boolean check(int height, int width,int brown, int yellow) {
        int y = height*2 + width*2 -4;
        int x = (height-2) * (width-2);
        return brown == y && yellow == x;
    }
}