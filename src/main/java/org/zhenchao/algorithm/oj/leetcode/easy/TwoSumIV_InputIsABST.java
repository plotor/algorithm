package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 653. Two Sum IV - Input is a BST
 *
 * @author zhenchao.wang 2017-10-17 22:45
 * @version 1.0.0
 */
public class TwoSumIV_InputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        if (null == root) return false;
        List<Integer> list = new ArrayList<Integer>();
        this.inorderTraversal(root, list);
        int i = 0, j = list.size() - 1;
        while (i < j) {
            int sum = list.get(i) + list.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    /**
     * 中序遍历获取有序集合
     *
     * @param node
     * @param list
     */
    private void inorderTraversal(TreeNode node, List<Integer> list) {
        if (null != node.left) {
            this.inorderTraversal(node.left, list);
        }
        list.add(node.val);
        if (null != node.right) {
            this.inorderTraversal(node.right, list);
        }
    }

}
