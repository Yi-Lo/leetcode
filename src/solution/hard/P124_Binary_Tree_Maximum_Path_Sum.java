package solution.hard;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/9 13:44
 * @version 1.0
 * @topics Tree、Depth-first Search、Recursion
 * @urllink https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class P124_Binary_Tree_Maximum_Path_Sum {

    public static int max = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        int sum = root.val + left + right;
        max = Math.max(max, sum);
        return root.val + Math.max(left, right);
    }
}
