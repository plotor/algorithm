package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.24 Swap Nodes in Pairs
 *
 * @author zhenchao.wang 2017-04-30 16:38
 * @version 1.0.0
 */
public class SwapNodesInPairs {

    /**
     * 两两交换结点
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        // 利用一个tmp结点串起所有的结点
        ListNode newHead = new ListNode(-1), tmp = newHead;
        ListNode l = head, r = head.next;
        while (null != r) {
            l.next = r.next;
            r.next = l;
            tmp.next = r;
            tmp.next.next = l;
            tmp = tmp.next.next;
            l = l.next;
            if (null == l) {
                break;
            }
            r = l.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtils.build(1, 2, 3, 4);
        SwapNodesInPairs snp = new SwapNodesInPairs();
        ListNodeUtils.display(snp.swapPairs(head));
    }

}
