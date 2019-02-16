### Sum Root to Leaf Numbers

> No.129, medium

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

```
eg.
    1
   / \
  2   3
```

The root-to-leaf path 1->2 represents the number 12.  
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

#### 分析

题目要求给定一个二叉树，然后计算所有从根结点到叶子结点路径上的数值构成的数之和，这道题还是需要借助于先序遍历。

#### 实现

```java
/**
 * 基于先序遍历（递归）
 *
 * @param root
 * @return
 */
public int sumNumbers(TreeNode root) {
    return this.preorderTraversal(root, 0);
}

private int preorderTraversal(TreeNode node, int num) {
    if (null == node) return 0;
    num = num * 10 + node.val;
    if (null == node.left && null == node.right) {
        // 当前是叶子结点
        return num;
    }
    return this.preorderTraversal(node.left, num) + this.preorderTraversal(node.right, num);
}
```
