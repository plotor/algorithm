package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.83 Remove Duplicates from Sorted List
 *
 * @author zhenchao.wang 2017-06-19 18:19
 * @version 1.0.0
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode op = head, pre = head, idx = head.next;
        while (idx != null) {
            if (pre.val != idx.val) {
                op.next = idx;
                op = op.next;
                pre = idx;
            }
            idx = idx.next;
        }
        if (op.next != null) op.next = null;
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList rdsl = new RemoveDuplicatesFromSortedList();
        ListNode head = ListNodeUtils.build(1, 2, 3);
        ListNodeUtils.display(rdsl.deleteDuplicates(head));
    }

}
