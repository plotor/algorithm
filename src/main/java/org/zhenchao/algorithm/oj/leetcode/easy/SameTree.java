package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. Same Tree
 *
 * @author zhenchao.wang 2017-7-16 16:02:32
 * @version 1.0.0
 */
public class SameTree {

    /**
     * 递归的方式，同时先序遍历两个树
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null) {
            return false;
        } else if (q == null) {
            return false;
        } else if (p.val != q.val) {
            return false;
        } else {
            return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
        }
    }

    /**
     * 非递归的方法，采用层次遍历
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeNonRecursive(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> qQueue = new LinkedList<TreeNode>();
        pQueue.add(p);
        qQueue.add(q);
        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pnode = pQueue.poll();
            TreeNode qnode = qQueue.poll();
            if (pnode != null && qnode == null) {
                return false;
            } else if (pnode == null && qnode != null) {
                return false;
            } else if (pnode == null && qnode == null) {
                continue;
            } else if (pnode.val != qnode.val) {
                return false;
            } else {
                pQueue.offer(pnode.left);
                pQueue.offer(pnode.right);
                qQueue.offer(qnode.left);
                qQueue.offer(qnode.right);
            }
        }

        if (!pQueue.isEmpty() || !qQueue.isEmpty()) {
            return false;
        }

        return true;
    }

}
