package solution.easy;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yi-Lo
 * 2021/1/21 19:21
 * @version 1.0
 * @topics Bit Manipulation、Array、Math
 * @urllink https://leetcode-cn.com/problems/missing-number/
 */
public class P268_Missing_Number {

    public static int missingNumber_s1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing;
    }

    public static int missingNumber_s2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= nums.length; i++) {
            set.add(i);
        }
        for (int num : nums) {
            set.remove(num);
        }
        return set.iterator().next();
    }

    public static int missingNumber_s3(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber_s1(nums));
        System.out.println(missingNumber_s2(nums));
        System.out.println(missingNumber_s3(nums));
    }
}
