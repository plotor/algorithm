### Validate Binary Search Tree

> No.98, medium

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys less than the node's key.
- The right subtree of a node contains only nodes with keys greater than the node's key.
- Both the left and right subtrees must also be binary search trees.


Example 1:

```
eg.
    2
   / \
  1   3
```

Binary tree [2,1,3], return true.

Example 2:

```
eg.
    1
   / \
  2   3
```

Binary tree [1,2,3], return false.

#### 分析

题目要求判断给定的二叉树是否是一棵 BST，BST的特点是中序遍历会得到一个非递减的有序集合，我们可以从这个角度出发，这道题采用非递归中序遍历实现起来会更加简单。

#### 实现

```java
/**
 * 采用非递归中序遍历
 *
 * @param root
 * @return
 */
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode pre = null;
    while (null != root || !stack.isEmpty()) {
        while (null != root) {
            stack.add(root);
            root = root.left;
        }
        if (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != pre && pre.val >= node.val) return false;
            pre = node;
            root = node.right;
        }
    }
    return true;
}
```