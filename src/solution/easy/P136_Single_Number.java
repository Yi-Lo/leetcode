package solution.easy;

import java.util.HashSet;

/**
 * @author Yi-Lo
 * 2021/1/1 12:11
 * @version 1.0
 * @topics Bit Manipulation、Hash Table
 * @urllink https://leetcode-cn.com/problems/single-number/
 */
public class P136_Single_Number {

    public static int singleNumber_s1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }

    public static int singleNumber_s2(int[] nums) {
        int value = 0;
        for (int num : nums) {
            value ^= num;
        }
        return value;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber_s1(new int[]{2, 2, 1}));
        System.out.println(singleNumber_s2(new int[]{4, 1, 2, 1, 2}));
    }
}
