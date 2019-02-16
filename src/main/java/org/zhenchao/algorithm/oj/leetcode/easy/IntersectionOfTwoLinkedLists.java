package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 *
 * @author zhenchao.wang 2015-10-3 14:23:40
 * @version 1.0.0
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode ha = headA, hb = headB;
        int la = 0, lb = 0;
        // 计算链表 A 的长度
        while (ha.next != null) {
            la++;
            ha = ha.next;
        }
        // 计算链表 B 的长度
        while (hb.next != null) {
            lb++;
            hb = hb.next;
        }
        // 如果最后一个结点都不相同，那么肯定不存在交叉
        if (ha != hb) {
            return null;
        }

        // 找到同一起点
        ha = headA;
        hb = headB;
        if (la > lb) {
            int i = 0;
            while (i < (la - lb)) {
                ha = ha.next;
                i++;
            }
        } else if (la < lb) {
            int i = 0;
            while (i < (lb - la)) {
                hb = hb.next;
                i++;
            }
        }
        // 遍历寻找交叉点
        while (ha != null) {
            if (ha == hb) {
                return ha;
            } else {
                ha = ha.next;
                hb = hb.next;
            }
        }
        return null;
    }
}
