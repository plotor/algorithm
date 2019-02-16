package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * 234. Palindrome Linked List
 *
 * @author zhenchao.wang 2017-10-22 14:28
 * @version 1.0.0
 */
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (null == head || null == head.next) return true;

        // 采用快慢指针找到链表的中点（如果是偶数个元素则选择靠左的一个）
        ListNode fast = head, slow = head;
        while (true) {
            fast = fast.next;
            if (null == fast || null == fast.next) break;
            fast = fast.next;
            slow = slow.next;
        }

        // 将 slow 后续的链表逆置
        ListNode curr = slow.next.next, next;
        slow.next.next = null; // 必须设置作为逆置后链表的尾结点的next指针为null
        while (null != curr) {
            next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
            curr = next;
        }

        // 遍历比对
        slow = slow.next;
        while (null != slow) {
            if (head.val != slow.val) return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = ListNodeUtils.build(1, 2, 2, 1);
        System.out.println(pll.isPalindrome(head));
    }

}
