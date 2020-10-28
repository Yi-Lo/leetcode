package solution.medium;

import structure.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Yi-Lo
 * 2020/10/28 18:45
 * @version 1.0
 * @topics Tree、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class P429_Nary_Tree_Level_Order_Traversal {

    private static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> levelOrder(Node root) {
        if (root != null) {
            traverseNode(root, 0);
        }
        return result;
    }

    public static void traverseNode(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for (Node child : node.children) {
            traverseNode(child, level + 1);
        }
    }

    public static List<List<Integer>> levelOrder_s1(Node root) {
        List<List<Integer>> lists = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pop();
                level.add(node.val);
                queue.addAll(node.children);
            }
            lists.add(level);
        }
        return lists;
    }
}
