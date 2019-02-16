package org.zhenchao.algorithm.oj;

/**
 * Definition for singly-linked list.
 *
 * @author zhenchao.wang 2015-8-28 16:58:40
 */
public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val=" + val + ", next=" + (null == next ? null : next.val);
    }
}