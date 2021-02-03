package solution.medium;

import helper.ArrayHelper;

import java.util.Random;

/**
 * @author Yi-Lo
 * 2021/2/3 11:15
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/shuffle-an-array/
 */
public class P384_Shuffle_an_Array {

    static class Solution {

        private int[] original;

        Random random = new Random();

        public Solution(int[] nums) {
            original = nums;
        }

        public int[] reset() {
            return original;
        }

        public int[] shuffle() {
            int[] array = original.clone();
            for (int i = 0; i < array.length; i++) {
                int j = random.nextInt(array.length);
                int val = array[i];
                array[i] = array[j];
                array[j] = val;
            }
            return array;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution solution = new Solution(nums);
        ArrayHelper.println(solution.reset());
        ArrayHelper.println(solution.shuffle());
    }
}
