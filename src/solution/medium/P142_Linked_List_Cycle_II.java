package solution.medium;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/20 16:05
 * @version 1.0
 * @topics Linked List、Two Pointers
 * @urllink https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class P142_Linked_List_Cycle_II {

    public static ListNode detectCycle(ListNode head) {
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
        detectCycle(head);
    }
}
