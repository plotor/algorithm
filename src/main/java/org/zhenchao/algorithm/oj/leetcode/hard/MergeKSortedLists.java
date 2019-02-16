package org.zhenchao.algorithm.oj.leetcode.hard;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.23 - Merge k Sorted Lists
 *
 * @author zhenchao.wang 2017-04-29 17:46
 * @version 1.0.0
 */
public class MergeKSortedLists {

    /**
     * 本质上还是采用了两两merge的思想
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        return this.recursion(lists, 0, lists.length - 1);
    }

    /**
     * 如果仅仅是逐个逐个的merge，会TLE，所以这里两两merge完了再总的merge
     *
     * @param lists
     * @param low
     * @param high
     * @return
     */
    private ListNode recursion(ListNode[] lists, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            return this.mergeTwoSortedList(this.recursion(lists, low, mid), this.recursion(lists, mid + 1, high));
        }
        return lists[low];
    }

    /**
     * merge two sorted list
     *
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(-1);
        ListNode head = merge;
        ListNode p = list1, q = list2;
        while (null != p && null != q) {
            if (p.val < q.val) {
                merge.next = p;
                p = p.next;
            } else {
                merge.next = q;
                q = q.next;
            }
            merge = merge.next;
        }

        if (null != p) {
            merge.next = p;
        }
        if (null != q) {
            merge.next = q;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists mksl = new MergeKSortedLists();
        ListNode[] lists = {
            ListNodeUtils.build(1, 3, 5, 7, 9),
            ListNodeUtils.build(2, 3, 4, 8, 11),
            ListNodeUtils.build(2, 3, 5, 20, 21)};
        ListNode result = mksl.mergeKLists(lists);
        ListNodeUtils.display(result);
    }

}
