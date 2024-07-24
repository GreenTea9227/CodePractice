class Solution {
    public int solution(int hp) {
        
        int a = hp / 5;
        int b = hp % 5;
        return a+b/3+b%3;
    }
}