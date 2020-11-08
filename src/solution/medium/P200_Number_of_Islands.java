package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/8 19:36
 * @version 1.0
 * @topics Depth-first Search、Breadth-first Search、Union Find
 * @urllink https://leetcode-cn.com/problems/number-of-islands/
 */
public class P200_Number_of_Islands {

    public static int numIslands(char[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    destroyIsland(i, j, grid);
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

    public static void main(String[] args) {
        char[][] grid0 = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        char[][] grid1 = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        char[][] grid2 = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(numIslands(grid0));
        System.out.println(numIslands(grid1));
        System.out.println(numIslands(grid2));
    }
}
