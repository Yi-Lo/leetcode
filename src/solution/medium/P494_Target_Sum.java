package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/14 14:53
 * @version 1.0
 * @topics Depth-first Search、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/target-sum/
 */
public class P494_Target_Sum {

    public static int count = 0;

    public static int findTargetSumWays_s1(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return count;
    }

    public static void dfs(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S) count++;
        } else {
            dfs(nums, i + 1, sum + nums[i], S);
            dfs(nums, i + 1, sum - nums[i], S);
        }
    }

    public static int findTargetSumWays_s2(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum < S || (S + sum) % 2 == 1 ? 0 : subsetSum(nums, (S + sum) >> 1);
    }

    public static int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = s; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[s];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays_s1(nums, 3));
        System.out.println(findTargetSumWays_s2(nums, 3));
    }


}
