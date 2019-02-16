package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.ListNode;
import org.zhenchao.algorithm.oj.TreeNode;
import org.zhenchao.algorithm.util.ListNodeUtils;

/**
 * 109. Convert Sorted List to Binary Search Tree
 *
 * @author zhenchao.wang 2017-07-23 21:34
 * @version 1.0.0
 */
public class ConvertSortedListToBinarySearchTree {

    private static ListNode node;

    /**
     * 自底部向上构造
     *
     * @param head
     * @return
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        node = head;

        // 计算链表的长度
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return this.build(0, len - 1);
    }

    private TreeNode build(int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = this.build(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        root.right = this.build(mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree convert = new ConvertSortedListToBinarySearchTree();
        ListNode head = ListNodeUtils.build(1, 2, 3, 4, 5, 6, 7);
        convert.sortedListToBST(head);
    }

}
