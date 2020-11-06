package solution.medium;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/11/6 17:16
 * @version 1.0
 * @topics Tree、Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 */
public class P515_Find_Largest_Value_in_Each_Tree_Row {

    public List<Integer> largestValues_s1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pop();
                max = Math.max(node.val, max);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

    public List<Integer> largestValues_s2(TreeNode root) {
        List<Integer> max = new ArrayList<>();
        DFS(root, 0, max);
        return max;
    }

    public static void DFS(TreeNode root, int level, List<Integer> max) {
        if (root == null) return;
        if (max.size() <= level) {
            max.add(root.val);
        } else {
            int val = max.get(level);
            max.set(level, Math.max(val, root.val));
        }
        DFS(root.left, level + 1, max);
        DFS(root.right, level + 1, max);
    }

}
