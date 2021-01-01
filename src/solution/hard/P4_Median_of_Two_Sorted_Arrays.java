package solution.hard;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/12/31 14:01
 * @version 1.0
 * @topics Array、Binary Search、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */
public class P4_Median_of_Two_Sorted_Arrays {

    public static double findMedianSortedArrays_s1(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int target = (m + n) >> 1;
        int[] nums = new int[m + n];
        System.arraycopy(nums1, 0, nums, 0, m);
        System.arraycopy(nums2, 0, nums, m, n);
        Arrays.sort(nums);
        if ((m + n) % 2 != 0) return nums[target];
        return (nums[target - 1] + nums[target]) / 2.0;
    }

    public static double findMedianSortedArrays_s2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays_s2(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m, median1 = 0, median2 = 0;
        while (left <= right) {
            int i = (left + right) >> 1, j = ((m + n + 1) >> 1) - i;
            int nums_i1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i2 = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_j1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j2 = (j == n ? Integer.MAX_VALUE : nums2[j]);
            if (nums_i1 <= nums_j2) {
                median1 = Math.max(nums_i1, nums_j1);
                median2 = Math.min(nums_i2, nums_j2);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4};
        System.out.println(findMedianSortedArrays_s2(nums1, nums2));
    }
}
