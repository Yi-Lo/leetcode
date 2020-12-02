package solution.medium;

/**
 * @author Yi-Lo
 * 2020/12/2 18:10
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search、Union Find
 * @urllink https://leetcode-cn.com/problems/surrounded-regions/
 */
public class P130_Surrounded_Regions {

    private static int m, n;

    private static int[] dx = {0, 1, -1, 0};

    private static int[] dy = {-1, 0, 0, 1};

    public static void solve(char[][] board) {
        m = board.length;
        if (m == 0) return;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            DFS(board, i, 0);
            DFS(board, i, n - 1);
        }
        for (int i = 1; i < n - 1; i++) {
            DFS(board, 0, i);
            DFS(board, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void DFS(char[][] board, int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O') return;
        board[x][y] = 'A';
        for (int i = 0; i < 4; i++) {
            int tx = x + dx[i], ty = y + dy[i];
            DFS(board, tx, ty);
        }
    }
}
