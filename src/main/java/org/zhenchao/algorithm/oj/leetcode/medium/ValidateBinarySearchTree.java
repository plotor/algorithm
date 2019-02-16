package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.Stack;

/**
 * 98. Validate Binary Search Tree
 *
 * @author zhenchao.wang 2017-07-11 20:57
 * @version 1.0.0
 */
public class ValidateBinarySearchTree {

    /**
     * 采用非递归中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (null != pre && pre.val >= node.val) return false;
                pre = node;
                root = node.right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(vbst.isValidBST(root));
    }

}
