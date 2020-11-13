package solution.medium;

/**
 * @author Yi-Lo
 * 2020/11/13 19:34
 * @version 1.0
 * @topics Array、Binary Search
 * @urllink https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 */
public class P33_Search_in_Rotated_Sorted_Array {

    public static int search_s1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int search_s2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != target) {
                left++;
            } else {
                return left;
            }
            if (nums[right] != target) {
                right--;
            } else {
                return right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search_s1(nums, 6));
    }
}
