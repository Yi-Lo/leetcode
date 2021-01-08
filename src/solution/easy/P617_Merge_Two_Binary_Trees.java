package solution.easy;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/8 12:27
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
public class P617_Merge_Two_Binary_Trees {

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;
        TreeNode merged = new TreeNode(t1.val += t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;
    }
}
