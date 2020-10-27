package solution.medium;

import structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/27 17:42
 * @version 1.0
 * @topics Stack、Tree
 * @urllink https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class P144_Binary_Tree_Preorder_Traversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        lst.add(root.val);
        if (root.left != null) {
            lst.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            lst.addAll(preorderTraversal(root.right));
        }
        return lst;
    }

}
