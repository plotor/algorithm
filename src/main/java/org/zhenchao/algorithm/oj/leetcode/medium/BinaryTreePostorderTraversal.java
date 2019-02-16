package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author zhenchao.wang 2017-07-03 20:55
 * @version 1.0.0
 */
public class BinaryTreePostorderTraversal {

    /**
     * 后序遍历（基于栈）
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (null != root) stack.add(root); // 现将根节点入栈
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            /*
             * 1. 当前节点没有孩子节点
             * 2. 当前节点的孩子节点是上次访问的节点
             */
            if ((null == node.left && null == node.right)
                || (null != pre && (pre == node.right || pre == node.left))) {
                stack.pop();
                result.add(node.val);
                pre = node;
            } else {
                // 需要先右再左
                if (null != node.right) stack.add(node.right);
                if (null != node.left) stack.add(node.left);
            }
        }
        return result;
    }

    /**
     * 后序遍历（基于递归）
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        this.recursion(root, result);
        return result;
    }

    private void recursion(TreeNode node, List<Integer> list) {
        if (null == node) return;
        if (null != node.left) this.recursion(node.left, list);
        if (null != node.right) this.recursion(node.right, list);
        list.add(node.val);
    }

}
