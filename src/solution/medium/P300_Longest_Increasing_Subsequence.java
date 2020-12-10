package solution.medium;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/12/10 17:12
 * @version 1.0
 * @topics Binary Search、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class P300_Longest_Increasing_Subsequence {

    public static int lengthOfLIS_s1(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            len = Math.max(len, dp[i]);
        }
        return len;
    }

    public static int lengthOfLIS_s2(int[] nums) {
        int len = 1, n = nums.length;
        if (n == 0) return 0;
        int[] LIS = new int[n + 1];
        LIS[len] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > LIS[len]) {
                LIS[++len] = nums[i];
            } else {
                int l = 1, r = len, pos = 0;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (LIS[mid] < nums[i]) {
                        pos = mid;
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
                LIS[pos + 1] = nums[i];
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 2, 3};
        System.out.println(lengthOfLIS_s1(nums));
        System.out.println(lengthOfLIS_s2(nums));
    }
}
