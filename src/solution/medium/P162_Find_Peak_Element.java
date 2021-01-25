package solution.medium;

/**
 * @author Yi-Lo
 * 2021/1/25 16:15
 * @version 1.0
 * @topics Array、Binary Search
 * @urllink https://leetcode-cn.com/problems/find-peak-element/
 */
public class P162_Find_Peak_Element {

    public static int findPeakElement_s1(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }

    public static int findPeakElement_s2(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement_s1(nums));
        System.out.println(findPeakElement_s2(nums));
    }
}
