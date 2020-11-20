package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/20 21:12
 * @version 1.0
 * @topics Greedy、Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 */
public class P714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    public static int maxProfit(int[] prices, int fee) {
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        System.out.println(maxProfit(prices, 2));
    }

}
