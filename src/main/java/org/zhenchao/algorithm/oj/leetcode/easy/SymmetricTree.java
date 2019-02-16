package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 101. Symmetric Tree
 *
 * @author zhenchao.wang 2015-10-2 15:24:03
 * @version 1.0.0
 */
public class SymmetricTree {

    /**
     * 递归，每次比较left的left和right的right，以及left的right和right的left
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return this.check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        }

        return left.val == right.val
            && this.check(left.left, right.right)
            && this.check(left.right, right.left);

    }

}
