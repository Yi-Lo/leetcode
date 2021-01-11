package solution.medium;

import helper.ArrayHelper;

/**
 * @author Yi-Lo
 * 2021/1/11 11:55
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class P238_Product_of_Array_Except_Self {

    public static int[] productExceptSelf_s1(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        int[] answer = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }

    public static int[] productExceptSelf_s2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];
        answer[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        ArrayHelper.println(productExceptSelf_s2(new int[]{0, 0}));
        ArrayHelper.println(productExceptSelf_s2(new int[]{1, 0}));
        ArrayHelper.println(productExceptSelf_s2(new int[]{1, 2, 3, 4}));
    }
}
