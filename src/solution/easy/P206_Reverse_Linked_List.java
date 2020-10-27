package solution.easy;

import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/17 17:26
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class P206_Reverse_Linked_List {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode nextTemp = head.next;
            head.next = prev;
            prev = head;
            head = nextTemp;
        }
        return prev;
    }

}
