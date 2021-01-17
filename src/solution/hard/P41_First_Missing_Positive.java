package solution.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/1/17 16:33
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/first-missing-positive/
 */
public class P41_First_Missing_Positive {

    public static int firstMissingPositive_s1(int[] nums) {
        if (nums.length == 0) return 1;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
            max = Math.max(max, num);
        }
        for (int i = 1; i < max; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return max > 0 ? max + 1 : 1;
    }

    public static int firstMissingPositive_s2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(firstMissingPositive_s1(nums));
        System.out.println(firstMissingPositive_s2(nums));
    }
}
