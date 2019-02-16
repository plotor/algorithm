package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 110. Balanced Binary Tree
 *
 * @author zhenchao.wang 2017-07-29 09:50
 * @version 1.0.0
 */
public class BalancedBinaryTree {

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        return -1 != this.postTraversal(root);
    }

    /**
     * 返回结果为 -1 表示不平衡，同时返回结果也表示树的高度
     *
     * @param node
     * @return
     */
    private int postTraversal(TreeNode node) {
        if (null == node) return 0;

        int left = this.postTraversal(node.left);
        int right = this.postTraversal(node.right);

        if (Math.abs(left - right) > 1
            || -1 == left || -1 == right) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        boolean result = bbt.isBalanced(null);
        System.out.println(result);
    }

}
