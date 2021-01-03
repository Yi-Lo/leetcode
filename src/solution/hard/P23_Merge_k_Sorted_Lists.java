package solution.hard;

import structure.ListNode;

import java.util.*;

/**
 * @author Yi-Lo
 * 2021/1/2 21:03
 * @version 1.0
 * @topics Heap、Linked List、Divide and Conquer
 * @urllink https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class P23_Merge_k_Sorted_Lists {

    public static ListNode mergeKLists_s1(ListNode[] lists) {
        TreeMap<Integer, List<ListNode>> map = new TreeMap<>();
        for (ListNode head : lists) {
            while (head != null) {
                List<ListNode> list = map.get(head.val);
                if (list == null) {
                    list = new ArrayList<>();
                    map.put(head.val, list);
                }
                list.add(head);
                head = head.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (List<ListNode> nodeList : map.values()) {
            for (ListNode node : nodeList) {
                curr.next = new ListNode(node.val);
                curr = curr.next;
            }
        }
        return head.next;
    }

    public static ListNode mergeKLists_s2(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return head.next;
    }

    public static ListNode mergeKLists_s3(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[1];
        if (l > r) return null;
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode tail = head, pa = a, pb = b;
        while (pa != null && pb != null) {
            if (pa.val < pb.val) {
                tail.next = pa;
                pa = pa.next;
            } else {
                tail.next = pb;
                pb = pb.next;
            }
            tail = tail.next;
        }
        tail.next = (pa != null ? pa : pb);
        return head.next;
    }

}
