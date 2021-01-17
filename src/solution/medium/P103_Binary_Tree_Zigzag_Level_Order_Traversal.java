package solution.medium;

import structure.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Yi-Lo
 * 2021/1/17 16:38
 * @version 1.0
 * @topics Stack、Tree、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class P103_Binary_Tree_Zigzag_Level_Order_Traversal {

    public static List<List<Integer>> zigzagLevelOrder_s1(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (level % 2 == 0) {
                    if (node.left != null) stack.addLast(node.left);
                    if (node.right != null) stack.addLast(node.right);
                } else {
                    if (node.right != null) stack.addLast(node.right);
                    if (node.left != null) stack.addLast(node.left);
                }
            }
            while (!stack.isEmpty()) {
                queue.addLast(stack.pollLast());
            }
            if (list.size() > 0) {
                res.add(list);
            }
            level++;
        }
        return res;
    }

    public static List<List<Integer>> zigzagLevelOrder_s2(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        dfs(root, res, 0);
        return res;
    }

    public static void dfs(TreeNode root, List<List<Integer>> res, int depth) {
        if (root == null) return;
        if (res.size() == depth) res.add(new LinkedList<>());
        if (depth % 2 == 0) res.get(depth).add(root.val);
        else res.get(depth).add(0, root.val);
        dfs(root.left, res, depth + 1);
        dfs(root.right, res, depth + 1);
    }

    public static List<List<Integer>> zigzagLevelOrder_s3(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            if (res.size() % 2 == 1) {
                Collections.reverse(list);
            }
            res.add(list);
        }
        return res;
    }
}
