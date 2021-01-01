package solution.easy;

import structure.TreeNode;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2021/1/1 12:10
 * @version 1.0
 * @topics Tree、Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/symmetric-tree/
 */
public class P101_Symmetric_Tree {

    public static boolean isSymmetric_s1(TreeNode root) {
        return compare(root, root);
    }

    public static boolean compare(TreeNode node1, TreeNode node2) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node1);
        queue.add(node2);
        while (!queue.isEmpty()) {
            node1 = queue.poll();
            node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if ((node1 == null || node2 == null) || node1.val != node2.val) {
                return false;
            }
            queue.add(node1.left);
            queue.add(node2.right);
            queue.add(node1.right);
            queue.add(node2.left);
        }
        return true;
    }

    public static boolean isSymmetric_s2(TreeNode root) {
        if (root == null) return true;
        return isSymmetric_s2(root.left, root.right);
    }

    public static boolean isSymmetric_s2(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return isSymmetric_s2(left.left, right.right) && isSymmetric_s2(left.right, right.left);
    }
}
