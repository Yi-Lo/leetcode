package solution.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/4 9:59
 * @version 1.0
 * @topics Array
 * @urllink https://leetcode-cn.com/problems/missing-ranges/
 */
public class P163_Missing_Ranges {

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new LinkedList<>();
        StringBuilder builder;
        lower--;
        for (int i = -1; i < nums.length - 1 && lower < upper; i++) {
            if ((lower + 1) != nums[i + 1]) {
                builder = new StringBuilder(String.valueOf(lower + 1));
                if (nums[i + 1] != (lower + 2)) {
                    builder.append("->").append(Math.min(nums[i + 1] - 1, upper));
                }
                result.add(builder.toString());
            }
            lower = nums[i + 1];
        }
        if (lower < upper) {
            builder = new StringBuilder(String.valueOf(lower + 1));
            if ((lower + 1) != upper) {
                builder.append("->").append(upper);
            }
            result.add(builder.toString());
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(findMissingRanges(nums, 0, 99));
    }
}
