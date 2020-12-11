package solution.hard;

/**
 * @author Yi-Lo
 * 2020/12/11 17:43
 * @version 1.0
 * @topics String、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/distinct-subsequences/
 */
public class P115_Distinct_Subsequences {

    public static int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n + 1; j++) dp[0][j] = 1;
        char[] tChs = t.toCharArray(), sChs = s.toCharArray();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (tChs[i - 1] == sChs[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }
}
