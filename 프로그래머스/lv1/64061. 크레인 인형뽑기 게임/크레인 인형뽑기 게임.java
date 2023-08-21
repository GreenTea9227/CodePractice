import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int cx : moves) {
            cx -= 1;
            int cy = 0;
            while (cy < board[cx].length) {
                int current = board[cy][cx];
                if (current == 0) {
                    cy++;
                    continue;
                }
                   
                
                board[cy][cx] = 0;
                if (!stack.isEmpty() && stack.peek() == current) {
                    stack.pop();
                    answer+=2;
                } else {
                    stack.push(current);
                }
                break;
            }
            
        }
        return answer;
    }
}