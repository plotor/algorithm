package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 107. Binary Tree Level Order Traversal II
 *
 * @author zhenchao.wang 2017-07-23 14:56
 * @version 1.0.0
 */
public class BinaryTreeLevelOrderTraversalII {

    class TreeNodeWithLevel {
        TreeNode node;
        int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    /**
     * 相对于 I 来说，只需要在插入一个 list 到结果集中时选择前置插入即可
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) return result;
        Queue<TreeNodeWithLevel> queue = new LinkedList<TreeNodeWithLevel>();
        queue.add(new TreeNodeWithLevel(root, 0));
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNodeWithLevel lnode = queue.poll();
            if (lnode.level != result.size()) {
                result.add(0, new ArrayList<Integer>(list));
                list = new ArrayList<Integer>();
            }
            list.add(lnode.node.val);
            if (null != lnode.node.left) queue.add(new TreeNodeWithLevel(lnode.node.left, lnode.level + 1));
            if (null != lnode.node.right) queue.add(new TreeNodeWithLevel(lnode.node.right, lnode.level + 1));
        }
        if (!list.isEmpty()) {
            result.add(0, list);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII levelOrderTraversalII = new BinaryTreeLevelOrderTraversalII();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        List<List<Integer>> list = levelOrderTraversalII.levelOrderBottom(root);
        for (final List<Integer> l : list) {
            System.out.println(l);
        }
    }

}
