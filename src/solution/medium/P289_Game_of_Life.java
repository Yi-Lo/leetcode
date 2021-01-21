package solution.medium;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2021/1/21 19:24
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/game-of-life/
 */
public class P289_Game_of_Life {

    public static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static int[] dy = {-1, -1, -1, 0, 1, 1, 1, 0};

    public static void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int life = board[i][j];
                int live = count(board, i, j);
                if (life == 0 && live == 3) {
                    // dead to live
                    board[i][j] = 2;
                }
                if (life == 1 && (live < 2 || live > 3)) {
                    // live to dead
                    board[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static int count(int[][] board, int x, int y) {
        int live = 0;
        for (int i = 0; i < dx.length; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            if (Math.abs(board[tx][ty]) > 0 && board[tx][ty] != 2) live++;
        }
        return live;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        gameOfLife(board);
        ArrayHelper.println(board);
    }
}
