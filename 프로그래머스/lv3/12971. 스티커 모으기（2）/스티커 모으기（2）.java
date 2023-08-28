class Solution {
    public int solution(int sticker[]) {
        if (sticker.length == 1)
            return sticker[0];
        
        int[] first = new int[sticker.length];
        int[] second = new int[sticker.length];
        
        first[0] = sticker[0];
        first[1] = sticker[0];
        
        for (int i=2;i<sticker.length-1;i++) {
            first[i] = Math.max(first[i-1],first[i-2] + sticker[i]);
        }
        
        second[1] = sticker[1];
        for (int i=2;i<sticker.length;i++) {
            second[i] = Math.max(second[i-1],second[i-2] + sticker[i]);
        }


        return Math.max(first[first.length-2],second[second.length-1]);
    }
}