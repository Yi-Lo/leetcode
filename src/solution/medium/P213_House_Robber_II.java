package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/17 20:02
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/house-robber-ii/
 */
public class P213_House_Robber_II {

    public static int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    public static int rob(int[] nums, int start, int end) {
        int pre = 0, cur = 0;
        for (int i = start; i <= end; i++) {
            int p = pre, c = cur;
            pre = c + nums[i];
            cur = Math.max(p, c);
        }
        return Math.max(pre, cur);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }
}
