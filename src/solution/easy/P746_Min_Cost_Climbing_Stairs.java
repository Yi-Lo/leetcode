package solution.easy;

/**
 * @author Yi-Lo
 * 2020/12/9 18:28
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 */
public class P746_Min_Cost_Climbing_Stairs {

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < 2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }
}
