package solution.medium;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/1/19 13:13
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/odd-even-linked-list/
 */
public class P328_Odd_Even_Linked_List {

    public static ListNode oddEvenList_s1(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode even = head.next, odd = even.next;
        ListNode curr = head, tail = even;
        while (odd != null) {
            even.next = odd.next;
            curr.next = odd;
            curr = curr.next;
            even = even.next;
            if (even == null) {
                break;
            }
            odd = even.next;
        }
        curr.next = tail;
        return head;
    }

    public static ListNode oddEvenList_s2(ListNode head) {
        if (head == null) return head;
        ListNode tail = head.next;
        ListNode odd = head, even = tail;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tail;
        return head;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = NodeHelper.buildList(nums);
        NodeHelper.printValList(oddEvenList_s1(head));
    }
}
