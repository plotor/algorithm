package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.91 Reverse Linked List II
 *
 * @author zhenchao.wang 2017-06-28 14:47
 * @version 1.0.0
 */
public class ReverseLinkedListII {

    /**
     * 三指针法，不用考虑m和n的越界问题
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m >= n) return head;
        ListNode pt = new ListNode(-1), nh = pt;
        pt.next = head;
        ListNode left = head, right = head;
        int dis = n - m;
        while (dis-- > 0) right = right.next;
        dis = 1;
        while (dis++ < m) {
            pt = left;
            left = left.next;
            right = right.next;
        }
        pt.next = right;
        while (left != right) {
            ListNode tmp = left;
            left = left.next;
            tmp.next = right.next;
            right.next = tmp;
        }
        return nh.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListII rll = new ReverseLinkedListII();
        ListNode head = ListNodeUtils.build(1, 2, 3, 4, 5);
        ListNodeUtils.display(rll.reverseBetween(head, 1, 5));
    }

}
