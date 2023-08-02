import java.util.*;

class Solution {
    char[][] friendsBoard;
    int count = 0;

    public  int solution(int m, int n, String[] board) {
        friendsBoard = new char[m][n];

        for (int i = 0; i < board.length; i++) {
            friendsBoard[i] = board[i].toCharArray();
        }

        boolean flag = false;
        while (!flag) {
            flag = true;
            boolean[][] isChecked = new boolean[m][n];
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (friendsBoard[i][j] != '.' && checkSame(j, i, isChecked)) {
                        flag = false;
                    }
                }
            }
            delete(m, n, isChecked);
            pushDown(m,n);
        }
        return count;
    }

    boolean checkSame(int j, int i, boolean[][] isCheck) {
        char word = friendsBoard[i][j];

        for (int r = i; r < i + 2; ++r) {
            for (int c = j; c < j + 2; ++c) {
                if (friendsBoard[r][c] != word)
                    return false;
            }
        }

        for (int r = i; r < i + 2; ++r) {
            for (int c = j; c < j + 2; ++c) {
                isCheck[r][c] = true;
            }
        }
        return true;
    }

     void delete(int m, int n, boolean[][] isCheck) {
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (isCheck[i][j]) {
                    friendsBoard[i][j] = '.';
                    count++;
                }
            }
        }
    }

     void pushDown(int m, int n) {
        for (int c = 0; c < n; ++c) {
            for (int r = m - 1; r >= 0; --r) {
                if (friendsBoard[r][c] == '.') {
                    for (int nr = r - 1; nr >= 0; --nr) {
                        if (friendsBoard[nr][c] != '.') {
                            friendsBoard[r][c] = friendsBoard[nr][c];
                            friendsBoard[nr][c] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }
}