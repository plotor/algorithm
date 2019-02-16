package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * N0.21
 *
 * @author zhenchao.wang 2016-10-07 09:59
 * @version 1.0.0
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }

        // 构建起始点
        ListNode p1 = l1, p2 = l2;
        ListNode index;
        if (p1.val <= p2.val) {
            index = p1;
            p1 = l1.next;
        } else {
            index = p2;
            p2 = p2.next;
        }

        ListNode header = index;

        // 穿线
        while (null != p1 && null != p2) {
            if (p1.val <= p2.val) {
                index.next = p1;
                p1 = p1.next;
            } else {
                index.next = p2;
                p2 = p2.next;
            }
            index = index.next;
        }

        // 剩下的全部拼接
        index.next = null != p1 ? p1 : p2;

        return header;
    }

    public static void main(String[] args) {
        //ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(7);
        ListNode l15 = new ListNode(9);
        l14.next = l15;
        l13.next = l14;
        l12.next = l13;
        //l11.next = l12;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        ListNode l24 = new ListNode(8);
        ListNode l25 = new ListNode(10);
        l24.next = l25;
        l23.next = l24;
        l22.next = l23;
        l21.next = l22;

        MergeTwoSortedLists mtsl = new MergeTwoSortedLists();

        ListNode header = mtsl.mergeTwoLists(l12, l21);

        while (null != header) {
            System.out.println(header.val);
            header = header.next;
        }

    }

}
