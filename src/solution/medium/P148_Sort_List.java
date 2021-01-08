package solution.medium;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/1/8 12:22
 * @version 1.0
 * @topics Sort、Linked List
 * @urllink https://leetcode-cn.com/problems/sort-list/
 */
public class P148_Sort_List {

    public static ListNode sortList_s1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return merge(sortList_s1(head), sortList_s1(slow));
    }

    public static ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ListNode pr = new ListNode(0);
        ListNode pa = a, pb = b, pc = pr;
        while (pa != null && pb != null) {
            if (pa.val <= pb.val) {
                pc.next = pa;
                pa = pa.next;
            } else {
                pc.next = pb;
                pb = pb.next;
            }
            pc = pc.next;
        }
        pc.next = (pa == null) ? pb : pa;
        return pr.next;
    }

    public static ListNode sortList_s2(ListNode head) {
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        ListNode curr = head;
        while (curr != null) {
            minValue = Math.min(minValue, curr.val);
            maxValue = Math.max(maxValue, curr.val);
            curr = curr.next;
        }
        int[] count = new int[maxValue - minValue + 1];
        curr = head;
        while (curr != null) {
            count[curr.val - minValue]++;
            curr = curr.next;
        }
        curr = head;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                curr.val = i + minValue;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] val = {-1, 5, 3, 4, 0};
        ListNode head = NodeHelper.buildList(val);
        NodeHelper.printValList(sortList_s1(head));
        NodeHelper.printValList(sortList_s2(head));
    }
}
