package solution.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yi-Lo
 * 2021/1/20 20:09
 * @version 1.0
 * @topics Tree、Depth-first Search、Breadth-first Search
 * @urllink https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 */
public class P116_Populating_Next_Right_Pointers_in_Each_Node {

    public static Node connect_s1(Node root) {
        if (root == null) return root;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left != null) {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                    if (prev != null) {
                        prev.next = node.left;
                    }
                    node.left.next = node.right;
                    prev = node.right;
                }
            }
        }
        return root;
    }

    public static Node connect_s2(Node root) {
        if (root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (i < size - 1) {
                    node.next = queue.peek();
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    public static Node connect_s3(Node root) {
        if (root == null) return null;
        Node leftmost = root;
        while (leftmost.left != null) {
            Node head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }
}
