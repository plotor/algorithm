### Balanced Binary Tree

> No.110, easy

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

#### 分析

给定一棵二叉树，判断是否是平衡二叉树。

#### 实现

```java
/**
 * 后序遍历
 *
 * @param root
 * @return
 */
public boolean isBalanced(TreeNode root) {
    return -1 != this.postTraversal(root);
}

/**
 * 返回结果为 -1 表示不平衡，同时返回结果也表示树的高度
 *
 * @param node
 * @return
 */
private int postTraversal(TreeNode node) {
    if (null == node) return 0;

    int left = this.postTraversal(node.left);
    int right = this.postTraversal(node.right);

    if (Math.abs(left - right) > 1
            || -1 == left || -1 == right) {
        return -1;
    }

    return Math.max(left, right) + 1;
}
```
