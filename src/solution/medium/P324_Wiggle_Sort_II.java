package solution.medium;

import helper.ArrayHelper;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2021/2/3 11:12
 * @version 1.0
 * @topics Sort
 * @urllink https://leetcode-cn.com/problems/wiggle-sort-ii/
 */
public class P324_Wiggle_Sort_II {

    public static void wiggleSort(int[] nums) {
        int[] array = nums.clone();
        Arrays.sort(array);
        int n = array.length - 1;
        for (int i = 1; i < array.length; i += 2) {
            nums[i] = array[n--];
        }
        for (int i = 0; i < array.length; i += 2) {
            nums[i] = array[n--];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
        ArrayHelper.println(nums);
    }
}
