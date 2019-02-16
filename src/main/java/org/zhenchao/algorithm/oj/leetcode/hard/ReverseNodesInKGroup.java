package org.zhenchao.algorithm.oj.leetcode.hard;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.25 Reverse Nodes in k-Group
 *
 * @author zhenchao.wang 2017-04-30 16:24
 * @version 1.0.0
 */
public class ReverseNodesInKGroup {

    public ListNode reverseKGroup2(ListNode head, int k) {
        if (k == 1) return head;
        ListNode left = head, right, next = head, tmp = null;
        int n = 0;
        while (next != null) {
            next = next.next;
            if ((++n) % k == 0) {
                right = next;
                // 逆置 [left, right]
                ListNode t = this.reverse(left, right);
                if (n == k) {
                    head = next;
                }
                if (null != tmp) {
                    tmp.next = t;
                }
                tmp = left;
                left = left.next;
            }
        }
        return head;
    }

    /**
     * 逆序链表的指定区间[left, right]
     *
     * @param left
     * @param right
     * @return
     */
    public ListNode reverse(ListNode left, ListNode right) {
        ListNode p = left;
        ListNode q = left.next;
        while (p != right) {
            p.next = right.next;
            right.next = p;
            p = q;
            q = q.next;
        }
        return right;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1) return head;
        ListNode cur = head, start, pre = null, next;
        int n = 0;
        while (cur != null) {
            next = cur.next;
            if ((++n) % k == 0) {
                start = null == pre ? head : pre.next;
                head = null == pre ? cur : head;
                this.reverse(pre, next, start, cur);
                pre = start;
            }
            cur = next;
        }
        return head;
    }

    private void reverse(ListNode left, ListNode right, ListNode start, ListNode end) {
        ListNode pre = start, cur = start.next;
        ListNode next;
        while (cur != right) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        if (null != left) left.next = end;

        start.next = right;
    }

    public static void main(String[] args) {
        ReverseNodesInKGroup rng = new ReverseNodesInKGroup();
        ListNode list = ListNodeUtils.build(1, 2, 3, 4, 5, 6, 7, 8);
        /*ListNode left = list, right = list.next.next.next;
        ListNode start = rng.reverse(left, right);
        ListNodeUtils.display(start);
        ListNode tmp = left;
        left = left.next;
        right = left.next.next.next;
        tmp.next = rng.reverse(left, right);
        ListNodeUtils.display(start);*/
        ListNodeUtils.display(rng.reverseKGroup(list, 3));
    }

}
