class Solution
{
    public int solution(int[][] board)
    {
        int answer = 0;
        int ly = board.length;
        int lx = board[0].length;
        int[][] arr = new int[ly+1][lx+1];
        for (int i=1;i<=ly;i++) {
            for (int j=1;j<=lx;j++) { 
                arr[i][j] = board[i-1][j-1];
            }
        }
        
        
        for (int i=1;i<=ly;i++) {
            for (int j=1;j<=lx;j++) {
                if (arr[i][j] != 0) {
                    arr[i][j] = Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]))+1;
                    answer = Math.max(answer,arr[i][j]);
                }
            }
        }
        return answer * answer;
    }
    

}