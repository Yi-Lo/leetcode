package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/3 15:25
 * @version 1.0
 * @topics Bit Manipulation、Array、Backtracking
 * @urllink https://leetcode-cn.com/problems/subsets/
 */
public class P78_Subsets {

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    public static void backtrack(int start, int[] nums, List<Integer> visit) {
        result.add(new ArrayList<>(visit));
        for (int i = start; i < nums.length; i++) {
            visit.add(nums[i]);
            backtrack(i + 1, nums, visit);
            visit.remove(visit.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
