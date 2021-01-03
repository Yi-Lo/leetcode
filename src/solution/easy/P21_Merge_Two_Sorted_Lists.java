package solution.easy;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2020/10/17 19:34
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class P21_Merge_Two_Sorted_Lists {

    public static ListNode mergeTwoLists_s1(ListNode l1, ListNode l2) {
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

    public static ListNode mergeTwoLists_s2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists_s2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_s2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode a = NodeHelper.buildList(new int[]{1, 2, 4});
        ListNode b = NodeHelper.buildList(new int[]{1, 3, 4});
        ListNode node = mergeTwoLists_s2(a, b);
        NodeHelper.printValList(node);
    }
}
