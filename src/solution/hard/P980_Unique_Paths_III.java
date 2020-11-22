package solution.hard;

/**
 * @author Yi-Lo
 * 2020/11/22 19:19
 * @version 1.0
 * @topics Depth-first Search、Backtracking
 * @urllink https://leetcode-cn.com/problems/unique-paths-iii/
 */
public class P980_Unique_Paths_III {

    private static int[] dirX = {-1, 0, 1, 0};

    private static int[] dirY = {0, 1, 0, -1};

    public static int uniquePathsIII(int[][] grid) {
        int startX = 0, startY = 0, stepN = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                    continue;
                }
                if (grid[i][j] == 0) stepN++;
            }
        }
        return dfs(grid, startX, startY, stepN);
    }

    public static int dfs(int[][] grid, int x, int y, int step) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1) return 0;
        if (grid[x][y] == 2) return step == 0 ? 1 : 0;
        int result = 0;
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            result += dfs(grid, x + dirX[i], y + dirY[i], step - 1);
        }
        grid[x][y] = 0;
        return result;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}};
        System.out.println(uniquePathsIII(grid));
    }
}
