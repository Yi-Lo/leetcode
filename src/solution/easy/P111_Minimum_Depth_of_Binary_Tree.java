package solution.easy;

import structure.TreeNode;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/10/30 19:32
 * @version 1.0
 * @topics Tree、Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class P111_Minimum_Depth_of_Binary_Tree {

    public static int minDepth_s1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth_s1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth_s1(root.right), min_depth);
        }
        return min_depth + 1;
    }

    public static int minDepth_s2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
