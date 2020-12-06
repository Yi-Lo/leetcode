package solution.hard;

/**
 * @author Yi-Lo
 * 2020/12/6 18:15
 * @version 1.0
 * @topics Backtracking
 * @urllink https://leetcode-cn.com/problems/n-queens-ii/
 */
public class P52_N_Queens_II {

    private static int size;

    private static int count;

    public static int totalNQueens(int n) {
        count = 0;
        size = (1 << n) - 1;
        DFS(0, 0, 0);
        return count;
    }

    private static void DFS(int row, int ld, int rd) {
        if (row == size) {
            count++;
            return;
        }
        int pos = size & (~(row | ld | rd));
        while (pos != 0) {
            int p = pos & (-pos);
            pos &= pos - 1;
            DFS(row | p, (ld | p) << 1, (rd | p) >> 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(totalNQueens(4));
    }
}
