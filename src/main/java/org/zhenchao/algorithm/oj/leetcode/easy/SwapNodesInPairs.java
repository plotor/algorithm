package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * No.24
 *
 * @author zhenchao.wang 2016-10-07 11:36
 * @version 1.0.0
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }

        ListNode tmp = new ListNode(-1), header = tmp;
        ListNode left = head, right = head.next;
        while (null != left && null != right) {
            // 对调邻接的两个结点
            left.next = right.next;
            right.next = left;

            // 利用一个旁观指针记录新的结点的位置
            tmp.next = right;
            tmp.next.next = left;
            tmp = tmp.next.next;

            // 移动的下一个交换的结点位置
            left = left.next;
            if (null == left) {
                // 如果组合一对不匹配则直接退出循环
                break;
            }
            right = left.next;
        }

        return header.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(4);
        ListNode l15 = new ListNode(5);
        ListNode l16 = new ListNode(6);
        ListNode l17 = new ListNode(7);
        ListNode l18 = new ListNode(8);
        ListNode l19 = new ListNode(9);
        ListNode l20 = new ListNode(10);
        l19.next = l20;
        l18.next = l19;
        l17.next = l18;
        l16.next = l17;
        l15.next = l16;
        l14.next = l15;
        l13.next = l14;
        l12.next = l13;
        l11.next = l12;

        SwapNodesInPairs snp = new SwapNodesInPairs();
        ListNode header = snp.swapPairs(l11);
        while (null != header) {
            System.out.print(header.val + " ");
            header = header.next;
        }
    }

}
