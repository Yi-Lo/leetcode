package solution.medium;

import structure.ListNode;
import helper.NodeHelper;

/**
 * @author Yi-Lo
 * 2020/10/19 18:22
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class P24_Swap_Nodes_in_Pairs {

    public static ListNode swapPairs_s1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        prev.next = swapPairs_s1(next.next);
        next.next = prev;
        return next;
    }

    public static ListNode swapPairs_s2(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode temp = head;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode next = head.next;
        prev.next = swapPairs_s2(next.next);
        next.next = prev;
        return next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        ListNode head = NodeHelper.buildList(arr);
        head = swapPairs_s1(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
