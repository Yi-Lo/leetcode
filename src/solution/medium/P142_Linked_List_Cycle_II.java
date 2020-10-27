package solution.medium;

import structure.ListNode;
import helper.NodeHelper;

/**
 * @author Yi-Lo
 * 2020/10/20 16:05
 * @version 1.0
 * @urllink https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class P142_Linked_List_Cycle_II {

    public static ListNode detectCycle_s1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        int myVal = 10086;
        while (head != null && head.next != null) {
            head.val = myVal;
            if (head.next.val == myVal) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    public static ListNode detectCycle_s2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode prev = head;
                while (prev != slow) {
                    prev = prev.next;
                    slow = slow.next;
                }
                return prev;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 0, -4};
        ListNode head = NodeHelper.buildList(arr);
        NodeHelper.buildCycleList(head, 1);
        detectCycle_s2(head);
    }
}
