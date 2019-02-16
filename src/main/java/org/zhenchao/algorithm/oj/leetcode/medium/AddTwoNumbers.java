package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * No.2 Add Two Numbers
 *
 * @author zhenchao.wang 2017-04-23 09:44
 * @version 1.0.0
 */
public class AddTwoNumbers {

    /**
     * 加法计算都是从末位开始，所以题目中的链表已经反向存储，实则降低了题目难度
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (null == l1 && null == l2) {
            return null;
        }

        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (null != l1 && null != l2) {
            int value = l1.val + l2.val + carry;
            result.next = new ListNode(value % 10);
            carry = value / 10;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (null != l1) {
            int value = l1.val + carry;
            result.next = new ListNode(value % 10);
            carry = value / 10;
            result = result.next;
            l1 = l1.next;
        }

        while (null != l2) {
            int value = l2.val + carry;
            result.next = new ListNode(value % 10);
            carry = value / 10;
            result = result.next;
            l2 = l2.next;
        }

        if (carry == 1) {
            // 不要忘了最后一次的进位
            result.next = new ListNode(1);
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode l1 = ListNodeUtils.build(9, 9, 9, 9, 9);
        ListNode l2 = ListNodeUtils.build(9, 9, 9, 9);
        ListNodeUtils.display(atn.addTwoNumbers(l1, l2));
    }

}
