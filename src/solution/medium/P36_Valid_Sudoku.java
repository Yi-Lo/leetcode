package solution.medium;

/**
 * @author Yi-Lo
 * 2020/12/3 18:36
 * @version 1.0
 * @topics Hash Table
 * @urllink https://leetcode-cn.com/problems/valid-sudoku/
 */
public class P36_Valid_Sudoku {

    public static boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m][n + 1];
        int[][] box = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                int v = board[i][j] - '0';
                int k = (i / 3) * 3 + j / 3;
                if (row[i][v] == 1) return false;
                if (col[j][v] == 1) return false;
                if (box[k][v] == 1) return false;
                row[i][v] = 1;
                col[j][v] = 1;
                box[k][v] = 1;
            }
        }
        return true;
    }
}
