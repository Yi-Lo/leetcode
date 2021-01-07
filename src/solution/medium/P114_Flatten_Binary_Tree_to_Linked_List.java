package solution.medium;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/7 12:52
 * @version 1.0
 * @topics Tree、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 */
public class P114_Flatten_Binary_Tree_to_Linked_List {

    public static void flatten_s1(TreeNode root) {
        dfs(root);
    }

    public static TreeNode dfs(TreeNode root) {
        if (root == null) return null;
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);
        root.left = null;
        if (left != null) {
            root.right = left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = right;
        } else if (right != null) {
            root.right = right;
        }
        return root;
    }

    public static void flatten_s2(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode prev = next;
                while (prev.right != null) {
                    prev = prev.right;
                }
                prev.right = curr.right;
                curr.left = null;
                curr.right = next;
            }
            curr = curr.right;
        }
    }
}
