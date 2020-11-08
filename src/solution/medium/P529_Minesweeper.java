package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/8 19:39
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/minesweeper/
 */
public class P529_Minesweeper {

    private static int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};

    private static int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public static char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    public static void dfs(char[][] board, int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            if (board[tx][ty] == 'M') {
                cnt++;
            }
        }
        if (cnt > 0) {
            board[x][y] = (char) (cnt + '0');
        } else {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }

}
