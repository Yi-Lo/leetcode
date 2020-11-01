package solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/1 17:40
 * @version 1.0
 * @topics Backtracking
 * @urllink https://leetcode-cn.com/problems/combinations/
 */
public class P77_Combinations {

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k, new ArrayList<>());
        return result;
    }

    public static void backtrack(int s, int n, int k, List<Integer> visit) {
        if (k == 0) {
            result.add(new ArrayList<>(visit));
            return;
        }
        for (int i = s; i <= n - k + 1; i++) {
            visit.add(i);
            backtrack(i + 1, n, k - 1, visit);
            visit.remove(visit.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(13, 10));
    }
}
