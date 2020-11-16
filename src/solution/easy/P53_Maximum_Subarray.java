package solution.easy;

/**
 * @author Yi-Lo
 * 2020/11/16 20:49
 * @version 1.0
 * @topics Array、Divide and Conquer、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/maximum-subarray/
 */
public class P53_Maximum_Subarray {

    public static int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = nums[0];
        for (int num : nums) {
            curSum = Math.max(curSum + num, num);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));
    }
}
