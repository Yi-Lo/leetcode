package solution.easy;

import helper.NodeHelper;
import structure.ListNode;

/**
 * @author Yi-Lo
 * 2021/1/3 17:43
 * @version 1.0
 * @topics Linked List、Two Pointers
 * @urllink https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class P234_Palindrome_Linked_List {

    public static boolean isPalindrome_s1(ListNode head) {
        int len = 0, mov = 0;
        ListNode node = head, prev = null;
        ListNode left = head, right = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        mov = len / 2;
        while (mov-- > 0) {
            right = left.next;
            left.next = prev;
            prev = left;
            left = right;
        }
        if (len % 2 != 0) right = right.next;
        while (right != null) {
            if (right.val != prev.val) return false;
            right = right.next;
            prev = prev.next;
        }
        return true;
    }

    public static boolean isPalindrome_s2(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode prev = head, last = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            prev.next = last;
            last = prev;
        }
        if (fast != null) slow = slow.next;
        while (slow != null) {
            if (prev.val != slow.val) return false;
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static boolean isPalindrome_s3(ListNode head) {
        long hash1 = 0, hash2 = 0, h = 1;
        long seed = (long) (1e9 + 7);
        ListNode p = head;
        while (p != null) {
            hash1 = hash1 * seed + p.val;
            hash2 = hash2 + h * p.val;
            h *= seed;
            p = p.next;
        }
        return hash1 == hash2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1};
        ListNode head = NodeHelper.buildList(nums);
        System.out.println(isPalindrome_s1(head));
        System.out.println(isPalindrome_s2(head));
        System.out.println(isPalindrome_s3(head));
    }
}
