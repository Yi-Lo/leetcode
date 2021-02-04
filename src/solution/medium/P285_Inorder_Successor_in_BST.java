package solution.medium;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/2/4 10:03
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/inorder-successor-in-bst/
 */
public class P285_Inorder_Successor_in_BST {

    public static TreeNode inorderSuccessor_s1(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        int index = list.indexOf(p) + 1;
        return index == list.size() ? null : list.get(index);
    }

    public static void inorder(TreeNode node, List<TreeNode> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node);
        inorder(node.right, list);
    }

    public static TreeNode inorderSuccessor_s2(TreeNode root, TreeNode p) {
        TreeNode node = null, curr = root;
        while (curr != null && curr != p) {
            if (p.val < curr.val) {
                node = curr;
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        if (curr == null || curr.right == null) return node;
        curr = curr.right;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
}
