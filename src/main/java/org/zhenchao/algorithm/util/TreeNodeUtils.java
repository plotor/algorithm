package org.zhenchao.algorithm.util;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenchao.wang 2017-07-23 14:15
 * @version 1.0.0
 */
public class TreeNodeUtils {

    /**
     * 先序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        preorder(root, result);
        return result;
    }

    private static void preorder(TreeNode node, List<Integer> list) {
        if (null == node) return;
        list.add(node.val);
        if (null != node.left) preorder(node.left, list);
        if (null != node.right) preorder(node.right, list);
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    private static void inorder(TreeNode node, List<Integer> list) {
        if (null == node) return;
        if (null != node.left) inorder(node.left, list);
        list.add(node.val);
        if (null != node.right) inorder(node.right, list);
    }

    /**
     * 后序遍历
     *
     * @param root
     * @return
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        postorder(root, result);
        return result;
    }

    private static void postorder(TreeNode node, List<Integer> list) {
        if (null == node) return;
        if (null != node.left) postorder(node.left, list);
        if (null != node.right) postorder(node.right, list);
        list.add(node.val);
    }
}
