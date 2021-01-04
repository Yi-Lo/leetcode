package solution.medium;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2021/1/4 15:09
 * @version 1.0
 * @topics Sort、Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/sort-colors/
 */
public class P75_Sort_Colors {

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0, p2 = n - 1;
        for (int i = 0; i <= p2; i++) {
            while (i <= p2 && nums[i] == 2) {
                swap(nums, i, p2--);
            }
            if (nums[i] == 0) swap(nums, i, p0++);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        ArrayHelper.println(nums);
    }
}
