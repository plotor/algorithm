package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * 203. Remove Linked List Elements
 *
 * @author zhenchao.wang 2017-09-23 12:29
 * @version 1.0.0
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (null != head && head.val == val) head = head.next;
        if (null == head) return null;
        ListNode pre = head, curr = head.next;
        while (null != curr) {
            if (curr.val == val) {
                pre.next = curr.next;
            } else {
                pre = pre.next;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveLinkedListElements remove = new RemoveLinkedListElements();
        ListNode head = remove.removeElements(ListNodeUtils.build(6, 6, 6, 1, 6), 6);
        ListNodeUtils.display(head);
    }

}
