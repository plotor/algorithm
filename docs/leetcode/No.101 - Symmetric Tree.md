### Symmetric Tree

> No.101, easy

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

#### 分析

题目的要求是给定给定一棵二叉树，要求判定是否是左右对称的。

递归，每次比较left的left和right的right，以及left的right和right的left

#### 实现

```java
/**
 * 递归，每次比较left的left和right的right，以及left的right和right的left
 *
 * @param root
 * @return
 */
public boolean isSymmetric(TreeNode root) {
    if (root == null) {
        return true;
    }
    return this.check(root.left, root.right);
}

private boolean check(TreeNode left, TreeNode right) {
    if (left == null && right == null) {
        return true;
    } else if (left == null || right == null) {
        return false;
    }

    return left.val == right.val
            && this.check(left.left, right.right)
            && this.check(left.right, right.left);

}
```