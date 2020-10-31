package solution.medium;

import structure.TreeNode;

import java.util.Arrays;

/**
 * @author Yi-Lo
 * 2020/10/31 14:27
 * @version 1.0
 * @topics Tree、Depth-first Search、Array
 * @urllink https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class P105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        if (preorder.length == 1 && inorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int pos = locateNum(inorder, preorder[0]);
        root.left = buildTree(subArray(preorder, 1, pos + 1), subArray(inorder, 0, pos));
        root.right = buildTree(subArray(preorder, pos + 1, preorder.length), subArray(inorder, pos + 1, inorder.length));
        return root;
    }

    public static int[] subArray(int[] src, int start, int end) {
        return Arrays.copyOfRange(src, start, end);
    }

    public static int locateNum(int[] src, int num) {
        for (int i = 0; i < src.length; i++) {
            if (src[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};
        buildTree(preorder, inorder);
    }

}
