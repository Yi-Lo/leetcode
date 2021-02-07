package solution.medium;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2021/2/7 20:03
 * @version 1.0
 * @topics Math、Dynamic Programming
 * @urllink https://leetcode-cn.com/problems/continuous-subarray-sum/
 */
public class P523_Continuous_Subarray_Sum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum = sum % k;
            }
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {23, 2, 4, 6, 7}, nums2 = {23, 2, 6, 4, 7};
        System.out.println(checkSubarraySum(nums1, 6));
        System.out.println(checkSubarraySum(nums2, 6));
    }
}
