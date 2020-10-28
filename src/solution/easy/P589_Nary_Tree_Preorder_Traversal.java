package solution.easy;

import structure.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/28 18:28
 * @version 1.0
 * @topics Tree
 * @urllink https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class P589_Nary_Tree_Preorder_Traversal {

    public static List<Integer> preorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        lst.add(root.val);
        for (Node child : root.children) {
            lst.addAll(preorder(child));
        }
        return lst;
    }

    public static List<Integer> preorder_s2(Node root) {
        LinkedList<Integer> lst = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();
        if (root == null) {
            return lst;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollFirst();
            lst.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.addFirst(child);
            }
        }
        return lst;
    }
}
