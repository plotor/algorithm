package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * 147. Insertion Sort List
 *
 * @author zhenchao.wang 2017-08-19 11:06
 * @version 1.0.0
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        ListNode first = new ListNode(-1);
        while (null != head) {
            ListNode pre = first, cur = first.next;
            while (cur != null && cur.val < head.val) {
                pre = cur;
                cur = cur.next;
            }
            ListNode node = head;
            head = head.next;
            node.next = pre.next;
            pre.next = node;
        }
        return first.next;
    }

    public static void main(String[] args) {
        InsertionSortList isl = new InsertionSortList();
        ListNode head = ListNodeUtils.build(1);
        head = isl.insertionSortList(head);
        ListNodeUtils.display(head);
    }

}
