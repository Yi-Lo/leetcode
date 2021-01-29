package solution.medium;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2021/1/28 20:47
 * @version 1.0
 * @topics Sort
 * @urllink https://leetcode-cn.com/problems/largest-number/
 */
public class P179_Largest_Number {

    public static String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length()) {
                return b.compareTo(a);
            } else {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);
            }
        });
        if (arr[0].equals("0")) return "0";
        StringBuilder builder = new StringBuilder();
        for (String str : arr) {
            builder.append(str);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
