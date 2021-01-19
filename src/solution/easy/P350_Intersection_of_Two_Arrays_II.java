package solution.easy;

import helper.ArrayHelper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2021/1/19 13:15
 * @version 1.0
 * @topics Sort、Hash Table、Two Pointers、Binary Search
 * @urllink https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class P350_Intersection_of_Two_Arrays_II {

    public static int[] intersect_s1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect_s1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int index = 0;
        int[] intersection = new int[nums1.length];
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                count--;
                intersection[index++] = num;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static int[] intersect_s2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int idx = 0, idx1 = 0, idx2 = 0;
        int[] intersection = new int[Math.min(len1, len2)];
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else {
                intersection[idx++] = nums1[idx1];
                idx1++;
                idx2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, idx);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        ArrayHelper.println(intersect_s1(nums1, nums2));
        ArrayHelper.println(intersect_s2(nums1, nums2));
    }
}
