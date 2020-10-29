package solution.medium;

import structure.TreeNode;

import java.util.LinkedList;

/**
 * @author Yi-Lo
 * 2020/10/29 18:51
 * @version 1.0
 * @topics Tree、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class P98_Validate_Binary_Search_Tree {

    private static boolean result = true;

    private static LinkedList<Integer> queue = new LinkedList<>();

    public static boolean isValidBST(TreeNode root) {
        inOrderBST(root);
        return result;
    }

    public static void inOrderBST(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderBST(root.left);
        if (!queue.isEmpty()) {
            if (root.val <= queue.peekLast()) {
                result = false;
                return;
            }
        }
        queue.add(root.val);
        inOrderBST(root.right);
    }

    private static int pre = Integer.MIN_VALUE;

    public static boolean isValidBST_s1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST_s1(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST_s1(root.right);
    }

}
