package solution.hard;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/12/4 15:15
 * @version 1.0
 * @topics Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/sliding-puzzle/
 */
public class P773_Sliding_Puzzle {

    public static int slidingPuzzle(int[][] board) {
        int m = 2, n = 3, step = 0;
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                start.append(board[i][j]);
            }
        }
        int[][] neighbor = {{1, 3}, {0, 4, 2}, {1, 5}, {0, 4}, {3, 1, 5}, {4, 2}};
        HashSet<String> visited = new HashSet<>();
        LinkedList<String> queue = new LinkedList<>();
        visited.add(start.toString());
        queue.addLast(start.toString());
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (target.equals(str)) {
                    return step;
                }
                int idx = 0;
                while (str.charAt(idx) != '0') {
                    idx++;
                }
                for (int adj : neighbor[idx]) {
                    char[] chs = str.toCharArray();
                    char tmp = chs[idx];
                    chs[idx] = chs[adj];
                    chs[adj] = tmp;
                    String cur = new String(chs);
                    if (!visited.contains(cur)) {
                        visited.add(cur);
                        queue.addLast(cur);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        System.out.println(slidingPuzzle(board));
    }
}
