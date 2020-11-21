package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/21 18:25
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/unique-paths/
 */
public class P62_Unique_Paths {

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
