package solution.easy;

import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/1/20 20:08
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 */
public class P237_Delete_Node_in_a_Linked_List {

    public static void deleteNode_s1(ListNode node) {
        ListNode prev = node;
        while (node != null && node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
    }

    public static void deleteNode_s2(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
