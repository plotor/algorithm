package org.zhenchao.algorithm.oj;

/**
 * Definition for a binary tree node.
 *
 * @author zhenchao.wang 2015-8-28 16:58:40
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}