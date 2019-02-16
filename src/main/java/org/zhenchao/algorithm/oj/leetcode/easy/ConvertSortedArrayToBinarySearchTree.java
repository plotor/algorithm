package org.zhenchao.algorithm.oj.leetcode.easy;

import org.zhenchao.algorithm.oj.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 *
 * @author zhenchao.wang 2017-07-23 15:20
 * @version 1.0.0
 */
public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (null == nums) return null;
        return this.insert(nums, 0, nums.length - 1);
    }

    private TreeNode insert(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = this.insert(nums, left, mid - 1);
        node.right = this.insert(nums, mid + 1, right);
        return node;
    }

}
