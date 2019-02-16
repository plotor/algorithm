package org.zhenchao.algorithm.util;

import org.zhenchao.algorithm.oj.ListNode;

/**
 * @author zhenchao.wang 2017-04-23 10:16
 * @version 1.0.0
 */
public class ListNodeUtils {

    /**
     * 由传入的多个元素构建链表
     *
     * @param elements
     * @return
     */
    public static ListNode build(int... elements) {
        ListNode node = new ListNode(-1);
        ListNode head = node;
        for (final int element : elements) {
            node.next = new ListNode(element);
            node = node.next;
        }
        return head.next;
    }

    /**
     * 遍历打印给定的链表
     *
     * @param node
     */
    public static void display(ListNode node) {
        if (null == node) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        ListNode head = node;
        while (null != head) {
            builder.append(head.val + "->");
            head = head.next;
        }
        System.out.println(builder.substring(0, builder.length() - 2));
    }
}
