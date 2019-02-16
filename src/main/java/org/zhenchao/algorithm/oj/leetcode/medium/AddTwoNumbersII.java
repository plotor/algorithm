package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

import java.util.Stack;

/**
 * No.445 Add Two Numbers II
 *
 * @author zhenchao.wang 2017-10-22 11:54
 * @version 1.0.0
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<Integer>(), s2 = new Stack<Integer>(), sum = new Stack<Integer>();
        // 链表转栈存储
        while (null != l1) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (null != l2) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        // 执行求和的过程
        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int s = s1.pop() + s2.pop() + carry;
            sum.push(s % 10);
            carry = s / 10;
        }
        while (!s1.isEmpty()) {
            int s = s1.pop() + carry;
            sum.push(s % 10);
            carry = s / 10;
        }
        while (!s2.isEmpty()) {
            int s = s2.pop() + carry;
            sum.push(s % 10);
            carry = s / 10;
        }
        if (carry > 0) sum.push(carry); // 防止最后一次进位

        // 栈转链表存储
        ListNode node = new ListNode(-1), root = node;
        while (!sum.isEmpty()) {
            node.next = new ListNode(sum.pop());
            node = node.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        AddTwoNumbersII atn = new AddTwoNumbersII();
        ListNode l1 = ListNodeUtils.build(1);
        ListNode l2 = ListNodeUtils.build(9, 9);
        ListNodeUtils.display(atn.addTwoNumbers(l1, l2));
    }

}
