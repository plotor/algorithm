package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeLinkNode;

/**
 * 116. Populating Next Right Pointers in Each Node
 *
 * @author zhenchao.wang 2017-08-05 09:58
 * @version 1.0.0
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * root 是一棵完全二叉树
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (null == root) return;
        if (null != root.right) {
            // right != null，则 left != null
            root.left.next = root.right;
            if (null != root.next) {
                // 父节点 next 存在，则 right.next = root.next.left
                root.right.next = root.next.left;
            }
        }
        this.connect(root.left);
        this.connect(root.right);
    }

}
