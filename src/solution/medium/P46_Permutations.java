package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/1 17:38
 * @version 1.0
 * @topics Backtracking
 * @urllink https://leetcode-cn.com/problems/permutations/
 */
public class P46_Permutations {

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> visit) {
        if (visit.size() == nums.length) {
            result.add(new ArrayList<>(visit));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visit.contains(nums[i])) {
                visit.add(nums[i]);
                backtrack(nums, visit);
                visit.remove(visit.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(permute(nums));
    }
}
