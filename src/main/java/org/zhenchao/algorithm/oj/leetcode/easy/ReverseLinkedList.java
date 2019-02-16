package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.206 Reverse Linked List
 *
 * @author zhenchao.wang 2015-10-9 20:39:18
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        ListNode root = head;
        while (p != null) {
            //删除p结点
            root.next = p.next;
            // 将p结点插入到头结点后面
            ListNode q = p;
            p = p.next;
            q.next = head;
            head = q;
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode root = rll.reverseList(ListNodeUtils.build(1, 2, 3, 4, 5, 6, 7));
        ListNodeUtils.display(root);
    }

}
