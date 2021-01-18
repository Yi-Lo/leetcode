package solution.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/1/18 13:06
 * @version 1.0
 * @topics Array、Hash Table
 * @urllink https://leetcode-cn.com/problems/contains-duplicate/
 */
public class P217_Contains_Duplicate {

    public static boolean containsDuplicate_s1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate_s2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate_s1(nums));
        System.out.println(containsDuplicate_s2(nums));
    }
}
