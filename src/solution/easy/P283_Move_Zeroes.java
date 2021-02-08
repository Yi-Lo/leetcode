package solution.easy;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2021/2/8 10:59
 * @version 1.0
 * @topics Array、Two Pointers
 * @urllink https://leetcode-cn.com/problems/move-zeroes/
 */
public class P283_Move_Zeroes {

    public static void moveZeroes_s1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = 0; j < nums.length; j++) {
                if (i > j && nums[j] == 0) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                    break;
                }
            }
        }
    }

    public static void moveZeroes_s2(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[temp++] = nums[i];
            }
        }
        for (int i = temp; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        moveZeroes_s2(nums);
        ArrayHelper.println(nums);
    }
}
