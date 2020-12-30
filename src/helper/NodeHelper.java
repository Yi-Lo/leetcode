package helper;

import structure.ListNode;

import java.util.ArrayList;

/**
 * @author Yi-Lo
 * 2020/10/19 18:24
 * @version 1.0
 */
public class NodeHelper {

    public static ListNode buildList(int[] val) {
        ListNode head = null;
        for (int i = val.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(val[i]);
            node.next = head;
            head = node;
        }
        return head;
    }

    public static ListNode buildCycleList(ListNode head, int pos) {
        ArrayList<ListNode> nodeList = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodeList.add(current);
            current = current.next;
        }
        ListNode tailNode = nodeList.get(nodeList.size() - 1);
        tailNode.next = nodeList.get(pos);
        return head;
    }

    public static void printValList(ListNode head) {
        ArrayList<Integer> valList = new ArrayList<>();
        while (head != null) {
            valList.add(head.val);
            head = head.next;
        }
        System.out.println(valList);
    }
}
