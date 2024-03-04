class Solution {
    
    private int[] arrx = {0,0,1,-1};
    private int[] arry = {1,-1,0,0};
    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for (int i=0;i<4;i++) {
            int x = arrx[i] + w;
            int y = arry[i] + h;
            if (x < 0 || y < 0 || x >= board[0].length || y >= board.length)
                continue;
            if (board[h][w].equals(board[y][x])) {
                answer++;
            }
        }
        return answer;
    }
    
  
}