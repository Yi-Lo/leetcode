package solution.hard;

import java.util.*;

/**
 * @author Yi-Lo
 * 2021/1/25 16:17
 * @version 1.0
 * @topics Sort、Binary Indexed Tree、Segment Tree、Binary Search、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self/
 */
public class P315_Count_of_Smaller_Numbers_After_Self {

    public static List<Integer> countSmaller_s1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) count++;
            }
            list.add(count);
        }
        return list;
    }

    public static int[] c;

    public static int[] a;

    public static List<Integer> countSmaller_s2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        discretization(nums);
        init(nums.length + 5);
        for (int i = nums.length - 1; i >= 0; i--) {
            int id = getId(nums[i]);
            list.add(query(id - 1));
            update(id);
        }
        Collections.reverse(list);
        return list;
    }

    public static void init(int length) {
        c = new int[length];
        Arrays.fill(c, 0);
    }

    public static int lowBit(int x) {
        return x & (-x);
    }

    public static void update(int pos) {
        while (pos < c.length) {
            c[pos] += 1;
            pos += lowBit(pos);
        }
    }

    public static int query(int pos) {
        int ret = 0;
        while (pos > 0) {
            ret += c[pos];
            pos -= lowBit(pos);
        }
        return ret;
    }

    public static void discretization(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int size = set.size();
        a = new int[size];
        int index = 0;
        for (int num : set) {
            a[index++] = num;
        }
        Arrays.sort(a);
    }

    public static int getId(int x) {
        return Arrays.binarySearch(a, x) + 1;
    }

    public static List<Integer> countSmaller_s3(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num < min) min = num;
            if (num > max) max = num;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
        }
        int[] BITree = new int[max - min + 1];
        Integer[] smaller = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            smaller[i] = getSum(nums[i], BITree);
            update(nums[i] + 1, BITree);
        }
        return Arrays.asList(smaller);
    }

    public static int getSum(int val, int[] BITree) {
        int sum = 0;
        while (val > 0) {
            sum += BITree[val];
            val &= val - 1;
        }
        return sum;
    }

    public static void update(int val, int[] BITree) {
        while (val < BITree.length) {
            BITree[val] += 1;
            val += val & -val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        System.out.println(countSmaller_s1(nums));
        System.out.println(countSmaller_s2(nums));
        System.out.println(countSmaller_s3(nums));
    }
}