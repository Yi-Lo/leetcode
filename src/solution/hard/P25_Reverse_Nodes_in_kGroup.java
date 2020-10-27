package solution.hard;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/20 18:17
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class P25_Reverse_Nodes_in_kGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) {
            return head;
        }
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode next = head.next;
        for (int i = 1; i < k; i++) {
            if (curr != null) {
                curr = curr.next;
            }
        }
        if (curr == null) {
            return head;
        }
        ListNode tail = reverseKGroup(curr.next, k);
        ListNode temp = curr.next;
        while (head != temp && next != null) {
            head.next = tail;
            tail = head;
            head = next;
            next = head.next;
        }
        if (k > 1 && curr.next == null) {
            curr.next = tail;
        }
        return curr;
    }

    public static void main(String[] args) {
        ListNode head = NodeHelper.buildList(new int[]{1, 2, 3, 4, 5});
        head = reverseKGroup(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
