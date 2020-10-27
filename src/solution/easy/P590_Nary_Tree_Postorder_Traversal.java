package solution.easy;

import structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yi-Lo
 * 2020/10/27 18:34
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class P590_Nary_Tree_Postorder_Traversal {

    public static List<Integer> postorder(Node root) {
        List<Integer> lst = new ArrayList<>();
        if (root == null) {
            return lst;
        }
        if (root.children != null) {
            for (Node node : root.children) {
                lst.addAll(postorder(node));
            }
        }
        lst.add(root.val);
        return lst;
    }

    public static List<Integer> postorder_s1(Node root) {
        Stack<Node> stack = new Stack<>();
        LinkedList<Integer> lst = new LinkedList<>();
        if (root == null) {
            return lst;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            lst.addFirst(node.val);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return lst;
    }

}
