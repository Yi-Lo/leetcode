package solution.easy;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/6 14:29
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/diameter-of-binary-tree/
 */
public class P543_Diameter_of_Binary_Tree {

    public static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
