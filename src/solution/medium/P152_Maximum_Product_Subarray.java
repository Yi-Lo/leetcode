package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/16 20:49
 * @version 1.0
 * @topics Array、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class P152_Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {
        int maxPdt = nums[0], minPdt = nums[0], resPdt = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int mxp = maxPdt, mnp = minPdt;
            maxPdt = Math.max(mxp * nums[i], Math.max(mnp * nums[i], nums[i]));
            minPdt = Math.min(mnp * nums[i], Math.min(mxp * nums[i], nums[i]));
            resPdt = Math.max(maxPdt, resPdt);
        }
        return resPdt;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(maxProduct(nums));
    }
}
