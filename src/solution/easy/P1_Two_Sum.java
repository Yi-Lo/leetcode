package solution.easy;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2020/10/22 17:20
 * @version 1.0
 * @topics Array、HashTable
 * @urllink https://leetcode-cn.com/problems/two-sum/
 */
public class P1_Two_Sum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            } else {
                map.put(need, i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        nums = twoSum(nums, 9);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
