package solution.hard;

/**
 * @author Yi-Lo
 * 2020/12/3 18:38
 * @version 1.0
 * @topics Hash Table、Backtracking
 * @urllink https://leetcode-cn.com/problems/sudoku-solver/
 */
public class P37_Sudoku_Solver {

    private static int m, n;

    public static void solveSudoku(char[][] board) {
        m = board.length;
        n = board[0].length;
        backtrack(board);
    }

    public static boolean backtrack(char[][] board) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    for (int v = 1; v <= 9; v++) {
                        char val = (char) ('0' + v);
                        if (valid(board, i, j, val)) {
                            board[i][j] = val;
                            if (backtrack(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean valid(char[][] board, int x, int y, char val) {
        for (int i = 0; i < m; i++) {
            if (board[i][y] == val) return false;
        }
        for (int i = 0; i < n; i++) {
            if (board[x][i] == val) return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int tx = (x / 3) * 3 + i;
                int ty = (y / 3) * 3 + j;
                if (board[tx][ty] == val) return false;
            }
        }
        return true;
    }
}
