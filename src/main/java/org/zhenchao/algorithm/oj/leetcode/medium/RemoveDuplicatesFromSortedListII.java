package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.82 Remove Duplicates from Sorted List II
 *
 * @author zhenchao.wang 2017-06-18 20:52
 * @version 1.0.0
 */
public class RemoveDuplicatesFromSortedListII {

    /**
     * 只有两种元素需要被删除：
     * 1. idx.val == idx.next.val
     * 2. idx.val == delete
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode nh = new ListNode(-1), op = nh, idx = head;
        ListNode delete = null;
        while (idx.next != null) {
            if (idx.val == idx.next.val || (null != delete && idx.val == delete.val)) {
                delete = idx;
            } else {
                op.next = idx;
                op = op.next;
            }
            idx = idx.next;
        }
        if (null == delete || delete.val != idx.val) {
            op.next = idx;
        } else {
            op.next = null;
        }
        return nh.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII rdsl = new RemoveDuplicatesFromSortedListII();
        // ListNode head = ListNodeUtils.build(1, 2, 2);
        ListNode head = ListNodeUtils.build(1, 1, 2, 3, 4, 4);
        ListNodeUtils.display(rdsl.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates2(ListNode head) {
        if (null == head || null == head.next) return head;
        ListNode op = null, pre = head, idx = head.next;
        int count = 0;
        while (idx != null) {
            // System.out.println("op=" + (null == op ? "NA" : op.val) + "\tpre=" + pre.val + "\tidx=" + idx.val + "\tcount=" + count);
            if (idx.val == pre.val) {
                count++;
            } else {
                if (count > 0) {
                    // 执行删除操作
                    if (null == op) {
                        head = idx;
                    } else {
                        op.next = idx;
                    }
                    count = 0;
                }
                pre = idx;
                op = null == op ? idx : ((null == idx.next || idx.val != idx.next.val) ? op.next : op);
            }
            idx = idx.next;
        }
        if (count > 0 && null != op) op.next = null;
        return null == op ? null : head;
    }

}
