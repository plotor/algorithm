package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.Stack;

/**
 * 112. Path Sum
 *
 * @author zhenchao.wang 2017-7-29 21:47:57
 * @version 1.0.0
 */
public class PathSum {

    /**
     * 先序遍历（递归）
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        return this.calculate(root, sum, 0);
    }

    private boolean calculate(TreeNode root, int sum, int val) {
        if (root == null) {
            return false;
        }
        val += root.val;
        if (val == sum
            && root.left == null && root.right == null) {
            return true;
        }
        return this.calculate(root.left, sum, val) || this.calculate(root.right, sum, val);
    }

    /**
     * 非递归
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSumNonRecursive(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Stack<TreeNode> nodes = new Stack<TreeNode>();
        Stack<Integer> sums = new Stack<Integer>();
        nodes.push(root);
        sums.push(root.val);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            Integer currSum = sums.pop();
            if (node.left == null && node.right == null) {
                if (currSum == sum) {
                    return true;
                }
            }

            if (node.right != null) {
                nodes.push(node.right);
                sums.push(currSum + node.right.val);
            }

            if (node.left != null) {
                nodes.push(node.left);
                sums.push(currSum + node.left.val);
            }

        }
        return false;
    }

}
