package solution.medium;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/2/8 10:57
 * @version 1.0
 * @topics Recursion、Linked List、Math
 * @urllink https://leetcode-cn.com/problems/add-two-numbers/
 */
public class P2_Add_Two_Numbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(), tail = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int v1 = l1 != null ? l1.val : 0;
            int v2 = l2 != null ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            tail.next = new ListNode(sum);
            tail = tail.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) tail.next = new ListNode(carry);
        return head.next;
    }

    public static void main(String[] args) {
        int[] val1 = {9, 9, 9, 9, 9, 9, 9}, val2 = {9, 9, 9, 9};
        ListNode l1 = NodeHelper.buildList(val1);
        ListNode l2 = NodeHelper.buildList(val2);
        ListNode head = addTwoNumbers(l1, l2);
        NodeHelper.printValList(head);
    }
}
