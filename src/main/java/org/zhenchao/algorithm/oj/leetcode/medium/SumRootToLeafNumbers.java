package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 *
 * @author zhenchao.wang 2017-08-13 10:32
 * @version 1.0.0
 */
public class SumRootToLeafNumbers {

    /**
     * 基于先序遍历（递归）
     *
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return this.preorderTraversal(root, 0);
    }

    private int preorderTraversal(TreeNode node, int num) {
        if (null == node) return 0;
        num = num * 10 + node.val;
        if (null == node.left && null == node.right) {
            // 当前是叶子结点
            return num;
        }
        return this.preorderTraversal(node.left, num) + this.preorderTraversal(node.right, num);
    }

}
