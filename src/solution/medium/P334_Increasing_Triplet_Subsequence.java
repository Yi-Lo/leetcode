package solution.medium;

/**
 * @author Yi-Lo
 * 2021/2/1 10:37
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/increasing-triplet-subsequence/
 */
public class P334_Increasing_Triplet_Subsequence {

    public static boolean increasingTriplet_s1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static boolean increasingTriplet_s2(int[] nums) {
        if (nums.length < 3) return false;
        int small = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= small) small = num;
            else if (num < middle) middle = num;
            else if (num > middle) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet_s1(nums));
        System.out.println(increasingTriplet_s2(nums));
    }
}
