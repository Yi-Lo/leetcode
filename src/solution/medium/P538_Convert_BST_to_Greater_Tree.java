package solution.medium;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/13 13:15
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class P538_Convert_BST_to_Greater_Tree {

    public static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
