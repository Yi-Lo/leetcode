package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/18 19:20
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class P309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown {

    public static int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int f0 = -prices[0], f1 = 0, f2 = 0;
        for (int i = 0; i < prices.length; i++) {
            int f01 = Math.max(f0, f2 - prices[i]);
            int f11 = f0 + prices[i];
            int f21 = Math.max(f1, f2);
            f0 = f01;
            f1 = f11;
            f2 = f21;
        }
        return Math.max(f1, f2);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }
}
