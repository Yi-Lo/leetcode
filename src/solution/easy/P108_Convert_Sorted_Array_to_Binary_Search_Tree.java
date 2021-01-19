package solution.easy;

import structure.TreeNode;

/**
 * @author Yi-Lo
 * 2021/1/19 13:04
 * @version 1.0
 * @topics Tree、Depth-first Search
 * @urllink https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class P108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) return null;
        int m = (l + r) >> 1;
        TreeNode node = new TreeNode(nums[m]);
        node.left = dfs(nums, l, m - 1);
        node.right = dfs(nums, m + 1, r);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        sortedArrayToBST(nums);
    }
}
