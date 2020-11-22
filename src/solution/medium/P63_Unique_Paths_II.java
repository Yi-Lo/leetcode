package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/22 19:13
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class P63_Unique_Paths_II {

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
