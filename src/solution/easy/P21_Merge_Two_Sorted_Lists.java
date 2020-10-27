package solution.easy;

import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/17 19:34
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class P21_Merge_Two_Sorted_Lists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null || l2 != null) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode head = null;
            ListNode tail = null;
            while (l1 != null) {
                while (l2 != null && l2.val <= l1.val) {
                    if (tail == null) {
                        tail = l2;
                    } else {
                        tail.next = l2;
                    }
                    if (head == null && tail != null) {
                        head = tail;
                    }
                    tail = l2;
                    l2 = l2.next;
                }
                if (tail == null) {
                    tail = l1;
                } else {
                    tail.next = l1;
                }
                if (head == null && tail != null) {
                    head = tail;
                }
                tail = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                tail.next = l2;
            }
            return head;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        b1.next = b2;
        b2.next = b3;
        ListNode node = mergeTwoLists(a1, b1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
