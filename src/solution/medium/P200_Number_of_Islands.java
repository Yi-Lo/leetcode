package solution.medium;

import structure.UnionFind;

/**
 * @author Yi-Lo
 * 2020/11/8 19:36
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search、Union Find
 * @urllink https://leetcode-cn.com/problems/number-of-islands/
 */
public class P200_Number_of_Islands {

    public static int numIslands_s1(char[][] grid) {
        int counter = 0;
        if (grid == null || grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    destroyIsland(i, j, grid);
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void destroyIsland(int row, int col, char[][] grid) {
        if (grid[row][col] != '1') {
            return;
        }
        grid[row][col] = '0';
        if (row < grid.length - 1) destroyIsland(row + 1, col, grid);
        if (col < grid[0].length - 1) destroyIsland(row, col + 1, grid);
        if (row > 0) destroyIsland(row - 1, col, grid);
        if (col > 0) destroyIsland(row, col - 1, grid);
    }

    public static int numIslands_s2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nr = grid.length, nc = grid[0].length;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                        uf.union(r * nc + c, (r - 1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r + 1][c] == '1') {
                        uf.union(r * nc + c, (r + 1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c + 1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        char[][] grid0 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands_s2(grid0));
        System.out.println(numIslands_s2(grid1));
        System.out.println(numIslands_s2(grid2));
    }
}
