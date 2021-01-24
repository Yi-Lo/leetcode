package solution.medium;

import java.util.HashMap;

/**
 * @author Yi-Lo
 * 2021/1/24 18:07
 * @version 1.0
 * @topics Hash Table、Linked List
 * @urllink https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 */
public class P138_Copy_List_with_Random_Pointer {

    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node prev = new Node(0);
        Node curr = head, copy = prev;
        HashMap<Node, Node> map = new HashMap<>(8);
        while (curr != null) {
            Node node = new Node(curr.val);
            map.put(curr, node);
            copy.next = node;
            curr = curr.next;
            copy = copy.next;
        }
        curr = head;
        copy = prev.next;
        while (curr != null) {
            copy.random = map.get(curr.random);
            curr = curr.next;
            copy = copy.next;
        }
        return prev.next;
    }
}
