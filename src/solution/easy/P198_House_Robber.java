package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/17 20:01
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/house-robber/
 */
public class P198_House_Robber {

    public static int rob(int[] nums) {
        switch (nums.length) {
            case 0: return 0;
            case 1: return nums[0];
            case 2: return Math.max(nums[0],nums[1]);
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(rob(nums));
    }
}
