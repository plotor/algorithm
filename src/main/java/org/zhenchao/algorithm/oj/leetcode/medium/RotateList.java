package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.61 Rotate List
 *
 * @author zhenchao.wang 2017-05-31 20:54
 * @version 1.0.0
 */
public class RotateList {

    /**
     * 双指针法
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (null == head || k == 0) {
            return head;
        }

        // 计算数组的长度
        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }
        k %= len; // k是允许超出数组长度的

        ListNode before = head, after = head;
        while (k-- > 0 && before.next != null) {
            before = before.next;
        }

        while (before.next != null) {
            before = before.next;
            after = after.next;
        }

        before.next = head;
        ListNode newHead = after.next;
        after.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        RotateList rl = new RotateList();
        int k = 3;
        // ListNode head = ListNodeUtils.build(1, 2, 3, 4, 5);
        ListNode head = ListNodeUtils.build(1, 2);
        ListNodeUtils.display(rl.rotateRight(head, k));
    }

}
