package solution.hard;

import java.util.*;

/**
 * @author Yi-Lo
 * 2020/11/5 19:06
 * @version 1.0
 * @topics Backtracking
 * @urllink https://leetcode-cn.com/problems/n-queens/
 */
public class P51_N_Queens {

    private static Set<Integer> cols = new HashSet<>();

    private static Set<Integer> xleft = new HashSet<>();

    private static Set<Integer> xright = new HashSet<>();

    private static List<List<String>> result = new ArrayList<>();

    public static List<List<String>> solveNQueens(int n) {
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(n, 0, queens);
        return result;
    }

    public static void backtrack(int num, int row, int[] queens) {
        if (row == num) {
            result.add(translate(queens, num));
        }
        for (int col = 0; col < num; col++) {
            if (cols.contains(col) || xleft.contains(col - row) || xright.contains(col + row)) {
                continue;
            }
            cols.add(col);
            xleft.add(col - row);
            xright.add(col + row);
            queens[row] = col;
            backtrack(num, row + 1, queens);
            queens[row] = -1;
            cols.remove(col);
            xleft.remove(col - row);
            xright.remove(col + row);
        }
    }

    public static List<String> translate(int[] queens, int num) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            char[] line = new char[num];
            Arrays.fill(line, '.');
            line[queens[i]] = 'Q';
            list.add(new String(line));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
}
