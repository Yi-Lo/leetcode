package solution.medium;

import structure.Point;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/12/4 15:13
 * @version 1.0
 * @topics Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/
 */
public class P1091_Shortest_Path_in_Binary_Matrix {

    public static int shortestPathBinaryMatrix_s1(int[][] grid) {
        if (grid[0][0] == 1 || grid[grid.length - 1][grid.length - 1] == 1) return -1;
        return BFS(grid, 0, 0);
    }

    public static int BFS(int[][] grid, int x, int y) {
        int[] dx = {1, -1, 0, 0, -1, 1, -1, 1};
        int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
        LinkedList<Point> queue = new LinkedList<>();
        queue.addLast(new Point(x, y, 1));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int px = point.getX();
            int py = point.getY();
            int step = point.getZ();
            if (px < 0 || px > grid.length - 1 || py < 0 || py > grid.length - 1 || grid[px][py] == 1) continue;
            if (px == grid.length - 1 && py == grid.length - 1) return step;
            grid[px][py] = 1;
            for (int i = 0; i < 8; i++) {
                queue.addLast(new Point(px + dx[i], py + dy[i], step + 1));
            }
        }
        return -1;
    }

    public static int shortestPathBinaryMatrix_s2(int[][] grid) {
        int n = grid.length;
        LinkedList<int[]> queue = new LinkedList<>();
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        queue.addLast(new int[]{0, 0});
        grid[0][0] = 1;
        while (!queue.isEmpty() && grid[n - 1][n - 1] == 0) {
            int[] point = queue.poll();
            int step = grid[point[0]][point[1]];
            for (int i = point[0] - 1; i <= point[0] + 1; i++) {
                for (int j = point[1] - 1; j <= point[1] + 1; j++) {
                    if (i >= 0 && i <= n - 1 && j >= 0 && j <= n - 1 && grid[i][j] == 0) {
                        queue.addLast(new int[]{i, j});
                        grid[i][j] = step + 1;
                    }
                }
            }
        }
        return grid[n - 1][n - 1] == 0 ? -1 : grid[n - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0}, {1, 1, 0}, {1, 1, 0}};
        System.out.println(shortestPathBinaryMatrix_s2(grid));
    }
}