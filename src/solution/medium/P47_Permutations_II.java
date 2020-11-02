package solution.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/2 18:13
 * @version 1.0
 * @topics Backtracking
 * @urllink https://leetcode-cn.com/problems/permutations-ii/
 */
public class P47_Permutations_II {

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        boolean[] visit = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, visit, new ArrayList<>());
        return result;
    }

    public static void backtrack(int[] nums, boolean[] visit, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visit[i]) continue;
            // when a number has the same value with its previous,
            // we can use this number only if his previous is visit
            if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) continue;
            visit[i] = true;
            list.add(nums[i]);
            backtrack(nums, visit, list);
            list.remove(list.size() - 1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }
}
