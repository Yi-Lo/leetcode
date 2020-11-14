package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/14 18:03
 * @version 1.0
 * @topics Array、Binary Search
 * @urllink https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
public class P153_Find_Minimum_in_Rotated_Sorted_Array {

    public static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if (nums[left] <= nums[mid] && nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));
    }
}
