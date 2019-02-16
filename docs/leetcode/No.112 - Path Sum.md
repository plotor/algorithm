### Path Sum

> No.112, easy

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example: Given the below binary tree and sum = 22,

```
eg.
          5
         / \
        4   8
       /   / \
      11  13  4
     /  \      \
    7    2      1
```

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

#### 分析

题目要求给定一个值，判断树中是否存在一条由根结点到叶结点的路径，保证路径上值的和为指定的值。

#### 实现

```java
/**
 * 先序遍历（递归）
 *
 * @param root
 * @param sum
 * @return
 */
public boolean hasPathSum(TreeNode root, int sum) {
    return this.calculate(root, sum, 0);
}

private boolean calculate(TreeNode root, int sum, int val) {
    if (root == null) {
        return false;
    }
    val += root.val;
    if (val == sum
            && root.left == null && root.right == null) {
        return true;
    }
    return this.calculate(root.left, sum, val) || this.calculate(root.right, sum, val);
}
```
