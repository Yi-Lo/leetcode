package solution.medium;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/26 21:30
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class P94_Binary_Tree_Inorder_Traversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        if (root != null) {
            list.add(root.val);
        }
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.right = b;
        b.left = c;
        System.out.println(inorderTraversal(a));
    }
}
