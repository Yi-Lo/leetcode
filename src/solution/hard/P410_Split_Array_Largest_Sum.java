package solution.hard;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/11/27 18:42
 * @version 1.0
 * @topics Binary Search、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class P410_Split_Array_Largest_Sum {

    public static int splitArray_s1(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, m); j++) {
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
                }
            }
        }
        return dp[n][m];
    }

    public static int splitArray_s2(int[] nums, int m) {
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
            if (left < nums[i]) {
                left = nums[i];
            }
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static boolean check(int[] nums, int x, int m) {
        int sum = 0, cnt = 1;
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > x) {
                cnt++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }
        return cnt <= m;
    }

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(splitArray_s2(nums, 2));
    }
}
