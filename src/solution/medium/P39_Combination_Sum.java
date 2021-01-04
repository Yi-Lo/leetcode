package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/4 15:06
 * @version 1.0
 * @topics Array、Backtracking
 * @urllink https://leetcode-cn.com/problems/combination-sum/
 */
public class P39_Combination_Sum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> visit = new ArrayList<>();
        dfs(candidates, target, 0, result, visit);
        return result;
    }

    public static void dfs(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> visit) {
        if (index == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(visit));
            return;
        }
        dfs(candidates, target, index + 1, result, visit);
        if (target - candidates[index] >= 0) {
            visit.add(candidates[index]);
            dfs(candidates, target - candidates[index], index, result, visit);
            visit.remove(visit.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        List<List<Integer>> result = combinationSum(candidates, 8);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
