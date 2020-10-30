package solution.easy;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2020/10/30 19:30
 * @version 1.0
 * @topics Tree、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class P104_Maximum_Depth_of_Binary_Tree {

    public static int maxDepth(TreeNode root) {
        return traverse(root, 0);
    }

    public static int traverse(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int left = traverse(root.left, depth + 1);
        int right = traverse(root.right, depth + 1);
        return Math.max(left, right);
    }
}
