package solution.medium;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/10 12:07
 * @version 1.0
 * @topics Tree、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/house-robber-iii/
 */
public class P337_House_Robber_III {

    public static int rob(TreeNode root) {
        int[] status = dfs(root);
        return Math.max(status[0], status[1]);
    }

    public static int[] dfs(TreeNode node) {
        if (node == null) return new int[2];
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);
        int selected = node.val + left[1] + right[1];
        int not_selected = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[]{selected, not_selected};
    }
}
