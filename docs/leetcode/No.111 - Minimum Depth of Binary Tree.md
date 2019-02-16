### Minimum Depth of Binary Tree

> No.111, easy

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

#### 分析

求二叉树的最小深度，这道题并不是简单利用 Math.min 那么简单，最小深度是指根结点到一棵叶子结点的最短距离，如果简单使用 min 会将只有左孩子节点或右孩子节点的结点也考虑进去。

#### 实现

```java
/**
 * 这道题并不是简单利用 Math.min 那么简单
 * 最小深度是指到一棵叶子节点（无孩子节点），如果简单使用 min 会将只有左孩子节点或右孩子节点的结点也考虑进去
 *
 * @param root
 * @return
 */
public int minDepth(TreeNode root) {
    if (root == null) {
        return 0;
    }
    int left = this.minDepth(root.left);
    int right = this.minDepth(root.right);
    if (left == 0 || right == 0) {
        return left > right ? left + 1 : right + 1;
    }
    return Math.min(left, right) + 1;
}
```
