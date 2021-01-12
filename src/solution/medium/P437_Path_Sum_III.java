package solution.medium;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2021/1/12 10:39
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/path-sum-iii/
 */
public class P437_Path_Sum_III {

    public static int pathSum_s1(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = dfs(root, sum);
        count += pathSum_s1(root.left, sum);
        count += pathSum_s1(root.right, sum);
        return count;
    }

    public static int dfs(TreeNode node, int sum) {
        int count = 0;
        if (node == null) return count;
        if (node.val == sum) count++;
        count += dfs(node.left, sum - node.val);
        count += dfs(node.right, sum - node.val);
        return count;
    }

    public static int pathSum_s2(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, map, 0, sum);
    }

    public static int dfs(TreeNode node, Map<Integer, Integer> map, int cur, int sum) {
        if (node == null) return 0;
        cur += node.val;
        int count = map.getOrDefault(cur - sum, 0);
        map.put(cur, map.getOrDefault(cur, 0) + 1);
        count += dfs(node.left, map, cur, sum);
        count += dfs(node.right, map, cur, sum);
        map.put(cur, map.get(cur) - 1);
        return count;
    }
}
