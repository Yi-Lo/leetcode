package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/11 11:57
 * @version 1.0
 * @topics Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/partition-equal-subset-sum/
 */
public class P416_Partition_Equal_Subset_Sum {

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) return false;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        int target = sum / 2;
        if (sum % 2 != 0 || max > target) return false;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }
}
