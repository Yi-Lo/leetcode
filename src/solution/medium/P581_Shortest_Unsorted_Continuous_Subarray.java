package solution.medium;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2021/1/14 14:55
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 */
public class P581_Shortest_Unsorted_Continuous_Subarray {

    public static int findUnsortedSubarray_s1(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int left = 0, right = nums.length - 1;
        while (left < nums.length && nums[left] == arr[left]) left++;
        while (right >= left && nums[right] == arr[right]) right--;
        return right - left + 1;
    }

    public static int findUnsortedSubarray_s2(int[] nums) {
        int len = nums.length, max = nums[0], min = nums[len - 1];
        int begin = 0, end = -1;
        for (int i = 0; i < len; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }
            if (nums[len - i - 1] > min) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray_s2(nums));
        System.out.println(findUnsortedSubarray_s1(nums));
    }
}
