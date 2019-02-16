package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 *
 * @author zhenchao.wang 2017-07-16 16:22
 * @version 1.0.0
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 存放结点和所在层次
     */
    private class Pair {
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (null == root) return result;
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(root, 0));
        List<Integer> list = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (pair.level != result.size()) {
                result.add(new ArrayList<Integer>(list));
                list = new ArrayList<Integer>();
            }
            list.add(pair.node.val);
            if (null != pair.node.left) queue.add(new Pair(pair.node.left, pair.level + 1));
            if (null != pair.node.right) queue.add(new Pair(pair.node.right, pair.level + 1));
        }
        if (!list.isEmpty()) result.add(new ArrayList<Integer>(list));
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal levelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        //root.left.left.left = new TreeNode(4);
        //root.left.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        List<List<Integer>> list = levelOrderTraversal.levelOrder(root);
        for (final List<Integer> l : list) {
            System.out.println(l);
        }
    }

}
