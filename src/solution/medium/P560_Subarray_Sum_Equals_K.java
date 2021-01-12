package solution.medium;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2021/1/12 10:42
 * @version 1.0
 * @topics Array、Hash Table
 * @urllink https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class P560_Subarray_Sum_Equals_K {

    public static int subarraySum_s1(int[] nums, int k) {
        int n = nums.length, count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                if (i + j > n) break;
                for (int m = 0; m < i; m++) {
                    sum += nums[j + m];
                }
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int subarraySum_s2(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end >= 0; end--) {
                sum += nums[end];
                if (sum == k) count++;
            }
        }
        return count;
    }

    public static int subarraySum_s3(int[] nums, int k) {
        int count = 0, preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(subarraySum_s1(nums, 5));
        System.out.println(subarraySum_s2(nums, 5));
        System.out.println(subarraySum_s3(nums, 5));
    }
}
