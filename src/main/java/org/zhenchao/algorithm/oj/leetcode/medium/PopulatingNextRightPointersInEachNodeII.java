package org.zhenchao.algorithm.oj.leetcode.medium;

import org.zhenchao.algorithm.oj.TreeLinkNode;

/**
 * 117. Populating Next Right Pointers in Each Node II
 *
 * @author zhenchao.wang 2017-08-05 10:18
 * @version 1.0.0
 */
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * 相对于 I 来说，这里的二叉树是任意的，不一定是完全二叉树
     * 所以存在跨多个 next 连线的情况，这道题目需要注意的一点
     * 是必须先处理右边，再处理左边，因为 next 指向右节点，所
     * 以在跨多个 next 时，必须保证右边的 next 是连通的
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (null == root) return;
        // 先处理右孩子节点
        if (null != root.right) {
            TreeLinkNode node = root.next;
            while (null != node) {
                if (null == node.left && null == node.right) {
                    node = node.next;
                    continue;
                }
                root.right.next = null != node.left ? node.left : node.right;
                break;
            }
        }

        // 再处理左孩子节点
        if (null != root.left) {
            if (null != root.right) {
                root.left.next = root.right;
            } else {
                TreeLinkNode node = root.next;
                while (null != node) {
                    if (null == node.left && null == node.right) {
                        node = node.next;
                        continue;
                    }
                    root.left.next = null != node.left ? node.left : node.right;
                    break;
                }
            }
        }

        // 必须先处理右子树
        this.connect(root.right);
        this.connect(root.left);
    }

}
