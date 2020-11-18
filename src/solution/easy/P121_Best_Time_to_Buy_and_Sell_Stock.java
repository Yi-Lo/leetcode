package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/18 19:18
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class P121_Best_Time_to_Buy_and_Sell_Stock {

    public static int maxProfit(int[] prices) {
        int max = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
