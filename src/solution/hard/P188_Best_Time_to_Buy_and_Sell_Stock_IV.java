package solution.hard;

/**
 * @author Yi-Lo
 * 2020/11/19 18:34
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/
 */
public class P188_Best_Time_to_Buy_and_Sell_Stock_IV {

    public static int maxProfit_s1(int k, int[] prices) {
        int max = 0;
        int n = prices.length;
        if (n <= 0 || k <= 0) return 0;
        if (k * 2 > n) {
            for (int i = 1; i < n; i++) {
                max += Math.max(0, prices[i] - prices[i - 1]);
            }
            return max;
        }
        int[][][] mp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                mp[i][j][0] = -1000000000;
                mp[i][j][1] = -1000000000;
            }
        }
        mp[0][0][0] = 0;
        mp[0][1][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                if (j > 0) {
                    mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        for (int j = 0; j <= k; j++) {
            max = Math.max(max, mp[n - 1][j][0]);
        }
        return max;
    }

    public static int maxProfit_s2(int k, int[] prices) {
        int n = prices.length;
        if (n < 1) return 0;
        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int max = -prices[0];
            // from the second day, on first day you cannot get profit
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], prices[j] + max);
                max = Math.max(max, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit_s2(2, prices));
    }
}
