package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/23 18:29
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/coin-change-2/
 */
public class P518_Coin_Change_2 {

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
    }
}
