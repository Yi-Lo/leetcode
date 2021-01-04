package solution.medium;

import helper.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2021/1/4 15:11
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/next-permutation/
 */
public class P31_Next_Permutation {

    public static void nextPermutation_s1(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                for (int j = n - 1; j >= i - 1; j--) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        Arrays.sort(nums, i, n);
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void nextPermutation_s2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= i && nums[i] >= nums[j]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left++, right--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 8, 4, 7, 6, 5, 3, 1};
        nextPermutation_s2(nums);
        ArrayHelper.println(nums);
    }
}
