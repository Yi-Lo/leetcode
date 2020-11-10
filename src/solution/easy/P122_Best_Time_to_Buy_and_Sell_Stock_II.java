package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/10 16:13
 * @version 1.0
 * @topics Greedy、Array
 * @urllink https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class P122_Best_Time_to_Buy_and_Sell_Stock_II {

    public static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

}
