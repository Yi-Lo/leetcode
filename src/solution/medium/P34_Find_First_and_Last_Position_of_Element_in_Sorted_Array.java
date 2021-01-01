package solution.medium;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2020/12/31 14:01
 * @version 1.0
 * @topics Array、Binary Search
 * @urllink https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums.length == 0) return result;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                int mid_head = mid, mid_tail = mid;
                while (mid_head > 0 && nums[mid_head] == nums[mid_head - 1]) {
                    mid_head--;
                }
                while (mid_tail < nums.length - 1 && nums[mid_tail] == nums[mid_tail + 1]) {
                    mid_tail++;
                }
                result[0] = mid_head;
                result[1] = mid_tail;
                return result;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        ArrayHelper.println(searchRange(nums, 8));
    }
}
