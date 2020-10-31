package solution.medium;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yi-Lo
 * 2020/10/31 14:29
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class P236_Lowest_Common_Ancestor_of_a_Binary_Tree {

    private static Map<TreeNode, Integer> depMap = new HashMap<>();

    private static Map<Integer, TreeNode> valMap = new HashMap<>();

    private static Map<TreeNode, TreeNode> nodeMap = new HashMap<>();

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traverse(root, 0);
        p = valMap.get(p.val);
        q = valMap.get(q.val);
        int dp = depMap.get(p);
        int dq = depMap.get(q);
        while (dp != dq) {
            if (dp > dq) {
                p = nodeMap.get(p);
                dp--;
            } else {
                q = nodeMap.get(q);
                dq--;
            }
        }
        if (p == q) {
            return p;
        }
        while (nodeMap.get(p) != nodeMap.get(q)) {
            p = nodeMap.get(p);
            q = nodeMap.get(q);
        }
        return nodeMap.get(p);
    }

    public static void traverse(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        valMap.put(root.val, root);
        depMap.put(root, depth);
        if (root.left != null) {
            nodeMap.put(root.left, root);
            traverse(root.left, depth + 1);
        }
        if (root.right != null) {
            nodeMap.put(root.right, root);
            traverse(root.right, depth + 1);
        }
    }
}
