package solution.easy;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/11/4 17:38
 * @version 1.0
 * @topics Bit Manipulation、Array、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/majority-element/
 */
public class P169_Majority_Element {

    public static int majorityElement_s1(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int count = 1;
        int majority = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                int len = i - start;
                if (len > count) {
                    majority = nums[i - 1];
                    count = len;
                }
                start = i;
            }
            if (i == nums.length - 1) {
                int len = i - start + 1;
                if (len > count) {
                    return nums[i];
                }
            }
        }
        return majority;
    }

    // Boyer-Moore Majority Vote Algorithm
    public static int majorityElement_s2(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement_s3(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }

    public static int divide(int[] nums, int low, int high) {
        if (low == high) {
            return nums[low];
        }
        int mid = (high - low) / 2 + low;
        int left = divide(nums, low, mid);
        int right = divide(nums, mid + 1, high);
        if (left == right) {
            return left;
        }
        int countLeft = count(nums, left, low, high);
        int countRight = count(nums, right, low, high);
        return countLeft > countRight ? left : right;
    }

    public static int count(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement_s3(new int[]{3, 2, 3}));
        System.out.println(majorityElement_s3(new int[]{3, 3, 4}));
        System.out.println(majorityElement_s3(new int[]{6, 6, 6, 7, 7}));
        System.out.println(majorityElement_s3(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
