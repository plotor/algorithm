package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 *
 * @author zhenchao.wang 2017-7-18 21:48:09
 * @version 1.0.0
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 计算一棵树的最大深度
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }

}
