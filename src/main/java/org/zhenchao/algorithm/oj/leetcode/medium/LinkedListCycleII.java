package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * 142. Linked List Cycle II
 *
 * @author zhenchao.wang 2017-08-19 10:38
 * @version 1.0.0
 */
public class LinkedListCycleII {

    /**
     * 按照 I 中的思路只能判定是否重合，但是重合时所在的点不是一定是起点，
     * 此时需要用两个指针，一个从重合点出发，一个从 head 出发，每次各走一步，相逢时所在的点就是环路起点
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        while (null != p && null != q) {
            p = p.next;
            q = q.next;
            if (q == null) return null;
            q = q.next;
            if (p == q) break;
        }
        if (null == p || null == q) return null;

        // 走到这里，说明两个结点重合了，存在环
        while (p != head) {
            p = p.next;
            head = head.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.build(1, 2);
        LinkedListCycleII llc = new LinkedListCycleII();
        System.out.println(llc.detectCycle(head));
    }

}
