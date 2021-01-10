package solution.hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/1/10 12:04
 * @version 1.0
 * @topics Union Find、Array
 * @urllink https://leetcode-cn.com/problems/longest-consecutive-sequence/
 */
public class P128_Longest_Consecutive_Sequence {

    public static int longestConsecutive_s1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int max_length = 0;
        for (int num : set) {
            int cur_length = 1;
            while (set.contains(++num)) {
                cur_length++;
            }
            max_length = Math.max(max_length, cur_length);
        }
        return max_length;
    }

    public static int longestConsecutive_s2(int[] nums) {
        if (nums.length < 2) return nums.length;
        Arrays.sort(nums);
        int max = 1, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                max = Math.max(max, ++count);
            } else if (nums[i] != nums[i - 1]) {
                count = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive_s1(nums));
        System.out.println(longestConsecutive_s2(nums));
    }
}
