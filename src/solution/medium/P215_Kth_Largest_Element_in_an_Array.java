package solution.medium;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2021/1/2 21:10
 * @version 1.0
 * @topics Heap、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class P215_Kth_Largest_Element_in_an_Array {

    public static int findKthLargest_s1(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static int findKthLargest_s2(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, k - 1);
    }

    public static int quickSort(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int pivot = nums[(l + r) >> 1], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] > pivot);
            do j--; while (nums[j] < pivot);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return (k <= j) ? quickSort(nums, l, j, k) : quickSort(nums, j + 1, r, k);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest_s2(nums, 4));
    }
}
