package solution.easy;

import helper.ArrayHelper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/2/8 11:02
 * @version 1.0
 * @topics Sort、Hash Table、Two Pointers、Binary Search
 * @urllink https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */
public class P349_Intersection_of_Two_Arrays {

    public static int[] intersection_s1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                res.add(num2);
            }
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for (int num : res) {
            ans[i++] = num;
        }
        return ans;
    }

    public static int[] intersection_s2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[length1 + length2];
        int index = 0, index1 = 0, index2 = 0;
        while (index1 < length1 && index2 < length2) {
            int num1 = nums1[index1], num2 = nums2[index2];
            if (num1 == num2) {
                if (index == 0 || num1 != intersection[index - 1]) {
                    intersection[index++] = num1;
                }
                index1++;
                index2++;
            } else if (num1 < num2) {
                index1++;
            } else {
                index2++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        ArrayHelper.println(intersection_s1(nums1, nums2));
        ArrayHelper.println(intersection_s2(nums1, nums2));
    }
}
