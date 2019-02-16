package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * @author zhenchao.wang 2017-07-03 20:54
 * @version 1.0.0
 */
public class BinaryTreePreorderTraversal {

    /**
     * 非递归（基于栈）
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if (null != root) stack.add(root);  // 根节点入栈
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (null != node.right) stack.add(node.right); // 先右孩子节点入栈
            if (null != node.left) stack.add(node.left); // 再左孩子节点入栈
        }
        return result;
    }

    /**
     * 先序遍历（基于递归）
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        this.recursion(root, result);
        return result;
    }

    private void recursion(TreeNode node, List<Integer> list) {
        if (null == node) return;
        list.add(node.val);
        if (null != node.left) this.recursion(node.left, list);
        if (null != node.right) this.recursion(node.right, list);
    }

}
