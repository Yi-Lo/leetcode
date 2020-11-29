package solution.hard;

/**
 * @author Yi-Lo
 * 2020/11/29 18:01
 * @version 1.0
 * @topics Divide and Conquer、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/burst-balloons/
 */
public class P312_Burst_Balloons {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 2][n + 2];
        int[] val = new int[n + 2];
        val[0] = val[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            val[i] = nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j <= n + 1; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], val[i] * val[k] * val[j] + dp[i][k] + dp[k][j]);
                }
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }
}
