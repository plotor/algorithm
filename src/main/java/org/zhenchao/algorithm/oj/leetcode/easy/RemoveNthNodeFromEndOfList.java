package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * No.19
 *
 * @author zhenchao.wang 2016-9-24 17:28:13
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode pa = head, pb = head;
        int len = 1;  // 用一个变量表示长度，在逻辑控制上会简单很多

        int i = 0;
        while ((i++) < n) {
            pa = pa.next;
            len++;
        }

        if (null == pa) {
            // 前头指针已经移出范围，肯定是删除第一个结点
            return head.next;
        }

        while (null != pa.next) {
            pa = pa.next;
            pb = pb.next;
            len++;
        }

        if (len == n) {
            // n等于链表长度，删除第一个结点
            return head.next;
        }

        // 其余情况都是删除pb的下一个结点
        pb.next = pb.next == null ? null : pb.next.next;

        return head;
    }

}
