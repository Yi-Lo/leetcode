package solution.easy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author Yi-Lo
 * 2021/1/12 10:40
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class P448_Find_All_Numbers_Disappeared_in_an_Array {

    public static List<Integer> findDisappearedNumbers_s1(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>(n);
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers_s2(int[] nums) {
        List<Integer> list = new LinkedList<>();
        int[] counter = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            counter[nums[i]]++;
        }
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static List<Integer> findDisappearedNumbers_s3(int[] nums) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) nums[index] *= -1;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers_s1(nums));
        System.out.println(findDisappearedNumbers_s2(nums));
        System.out.println(findDisappearedNumbers_s3(nums));
    }
}
