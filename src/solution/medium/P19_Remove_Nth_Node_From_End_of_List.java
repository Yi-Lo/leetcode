package solution.medium;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/12/30 22:02
 * @version 1.0
 * @topics Linked List、Two Pointers
 * @urllink https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class P19_Remove_Nth_Node_From_End_of_List {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode prev = curr;
        ListNode next = head;
        while (n-- > 0) {
            next = next.next;
        }
        if (next == null) {
            return head.next;
        }
        while (next != null) {
            prev = curr;
            curr = curr.next;
            next = next.next;
        }
        prev.next = curr.next;
        return head;
    }

    public static void main(String[] args) {
        int[] val = {1, 2, 3, 4, 5};
        ListNode head = NodeHelper.buildList(val);
        ListNode node = removeNthFromEnd(head, 2);
        NodeHelper.printValList(node);
    }
}
