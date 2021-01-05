package solution.easy;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/1/5 14:28
 * @version 1.0
 * @topics Linked List
 * @urllink https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class P160_Intersection_of_Two_Linked_Lists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = (pa == null) ? headB : pa.next;
            pb = (pb == null) ? headA : pb.next;
        }
        return pa;
    }


    public static void main(String[] args) {
        ListNode headA = NodeHelper.buildList(new int[]{4, 1, 8, 4, 5});
        ListNode headB = NodeHelper.buildList(new int[]{5, 6, 1, 8, 4, 5});
        ListNode node = getIntersectionNode(headA, headB);
        System.out.println(node.val);
    }
}
