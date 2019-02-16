### Convert Sorted Array to Binary Search Tree

> No.108, easy 

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

#### 分析

题目的意思是给定一个有序数组，然后构造 BST，数组的好处在于我们可以随机的选择需要的元素进行插入。

#### 实现

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
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
```