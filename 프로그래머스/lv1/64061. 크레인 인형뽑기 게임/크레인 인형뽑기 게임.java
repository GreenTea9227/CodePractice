import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<moves.length;i++) {
            int cx = moves[i]-1;

            for (int j=0;j<board[cx].length;j++) {
                if (board[j][cx] == 0)
                    continue;
                if (!stack.isEmpty() && stack.peek() == board[j][cx]) {
                    stack.pop();
                    answer+=2;
                } else 
                    stack.push(board[j][cx]);
                
                board[j][cx] = 0;
                break;
            }
            
        }
        return answer;
    }
}