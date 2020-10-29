package solution.easy;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2020/10/29 17:40
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class P226_Invert_Binary_Tree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
