package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 *
 * @author zhenchao.wang 2017-7-29 10:45:16
 * @version 1.0.0
 */
public class MinimumDepthOfBinaryTree {

    /**
     * 这道题并不是简单利用 Math.min 那么简单
     * 最小深度是指到一棵叶子节点（无孩子节点），如果简单使用 min 会将只有左孩子节点或右孩子节点的结点也考虑进去
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = this.minDepth(root.left);
        int right = this.minDepth(root.right);
        if (left == 0 || right == 0) {
            return left > right ? left + 1 : right + 1;
        }
        return Math.min(left, right) + 1;
    }

}
