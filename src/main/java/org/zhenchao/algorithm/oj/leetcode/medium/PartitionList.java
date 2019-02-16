package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.86 Partition List
 *
 * @author zhenchao.wang 2017-06-20 17:39
 * @version 1.0.0
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode g = head, op = new ListNode(-1), nh = op;
        while (null != g && g.val < x) {
            op = g;
            g = g.next;
        }
        // System.out.println(g.val);
        if (null == g) return head;
        ListNode idx = g.next, pre = g;
        while (null != idx) {
            if (idx.val < x) {
                pre.next = idx.next;
                ListNode tmp = idx;
                idx = idx.next;
                tmp.next = g;
                op.next = tmp;
                op = op.next;
            } else {
                pre = pre.next;
                idx = idx.next;
            }
        }
        return null == nh.next ? head : nh.next;
    }

    public static void main(String[] args) {
        PartitionList pl = new PartitionList();
        ListNode head = ListNodeUtils.build(1);
        ListNodeUtils.display(pl.partition(head, 2));
    }

}
