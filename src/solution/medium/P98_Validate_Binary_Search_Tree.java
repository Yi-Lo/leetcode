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

    public static boolean isValidBST_s1(TreeNode root) {
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

    public static boolean isValidBST_s2(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST_s2(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST_s2(root.right);
    }

    public static boolean isValidBST_s3(TreeNode root) {
        return validBST(root, null, null);
    }

    public static boolean validBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min) {
            return false;
        }
        if (max != null && root.val >= max) {
            return false;
        }
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }

}
