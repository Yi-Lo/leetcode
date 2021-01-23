package solution.medium;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/23 18:07
 * @version 1.0
 * @topics Tree、Binary Search
 * @urllink https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 */
public class P230_Kth_Smallest_Element_in_a_BST {

    public static int kthSmallest_s1(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list, k);
        return list.get(k - 1);
    }

    public static void dfs(TreeNode node, List<Integer> list, int limit) {
        if (node == null || list.size() >= limit) return;
        dfs(node.left, list, limit);
        list.add(node.val);
        dfs(node.right, list, limit);
    }

    public static int kthSmallest_s2(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (true) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pollLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
