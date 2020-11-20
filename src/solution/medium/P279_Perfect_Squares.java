package solution.medium;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/11/20 21:17
 * @version 1.0
 * @topics Breadth-first Search、Math、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/perfect-squares/
 */
public class P279_Perfect_Squares {

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; i + j * j <= n; j++) {
                dp[i + j * j] = Math.min(dp[i + j * j], dp[i] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(1000));
    }
}
