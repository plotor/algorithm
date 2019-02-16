package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * No.94 Binary Tree Inorder Traversal
 *
 * @author zhenchao.wang 2017-07-03 17:36
 * @version 1.0.0
 */
public class BinaryTreeInorderTraversal {

    /**
     * 中序遍历（基于栈）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (null != root || !stack.isEmpty()) {
            // 循环将左孩子节点入栈
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                // 出栈访问该节点
                TreeNode node = stack.pop();
                result.add(node.val);
                // 令 root = node.right
                root = node.right;
            }
        }
        return result;
    }

    /**
     * 中序遍历（基于递归）
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        this.recursion(root, result);
        return result;
    }

    /**
     * 递归的方法
     *
     * @param node
     * @param list
     */
    public void recursion(TreeNode node, List<Integer> list) {
        if (null == node) return;
        if (null != node.left) this.recursion(node.left, list);
        list.add(node.val);
        if (null != node.right) this.recursion(node.right, list);
    }

}
