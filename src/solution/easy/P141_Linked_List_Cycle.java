package solution.easy;

import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/19 18:01
 * @version 1.0
 * @topics Linked List、Two Pointers
 * @urllink https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class P141_Linked_List_Cycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(3);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(0);
        ListNode a4 = new ListNode(-4);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a2;
        System.out.println(hasCycle(a1));
    }

}
