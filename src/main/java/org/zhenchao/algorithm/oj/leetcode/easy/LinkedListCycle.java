package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * 141. Linked List Cycle
 *
 * @author zhenchao.wang 2017-08-19 10:24
 * @version 1.0.0
 */
public class LinkedListCycle {

    /**
     * 采用双指针
     * 一个一次走一步，一个一次走两步，如果存在环，一定会碰面
     *
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        while (null != p && null != q) {
            p = p.next;
            q = q.next;
            // 如果能够走到末尾，说明肯定没有环
            if (null == q) return false;
            q = q.next;
            if (p == q) return true;
        }
        return false;
    }

}
