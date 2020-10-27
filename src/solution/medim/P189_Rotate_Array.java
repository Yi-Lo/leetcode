package solution.medim;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2020/10/21 17:50
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/rotate-array/
 */
public class P189_Rotate_Array {

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = last;
        }
    }

    public static void rotate_s1(int[] nums, int k) {
        k = k % nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            map.put(index, nums[i]);
            index++;
        }
        int count = 1;
        for (int j = nums.length - k - 1; j >= 0; j--) {
            nums[nums.length - count] = nums[j];
            count++;
        }
        for (int m = 0; m < k; m++) {
            nums[m] = map.get(m);
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate_s1(nums, 3);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
