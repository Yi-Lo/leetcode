package design;

/**
 * @author Yi-Lo
 * 2021/2/5 10:41
 * @version 1.0
 */
public class TicTacToe {

    private int[] rows;
    private int[] cols;

    private int diagonal1 = 0;
    private int diagonal2 = 0;
    private int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        int num = (player == 2) ? -1 : 1;
        rows[row] += num;
        cols[col] += num;
        if (row == col) diagonal1 += num;
        if (col + row == n - 1) diagonal2 += num;
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diagonal1) == n || Math.abs(diagonal2) == n) {
            return player;
        }
        return 0;
    }
}
