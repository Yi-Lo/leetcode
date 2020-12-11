package solution.hard;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/12/11 17:53
 * @version 1.0
 * @topics Heap、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/race-car/
 */
public class P818_Race_Car {

    public static int racecar(int target) {
        int[] dp = new int[target + 3];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 4;
        for (int t = 3; t <= target; t++) {
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1 << k) - 1) {
                dp[t] = k;
                continue;
            }
            for (int j = 0; j < k - 1; j++) {
                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + (1 << j)] + k - 1 + j + 2);
            }
            if ((1 << k) - 1 - t < t) {
                dp[t] = Math.min(dp[t], dp[(1 << k) - 1 - t] + k + 1);
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(racecar(6));
    }
}
