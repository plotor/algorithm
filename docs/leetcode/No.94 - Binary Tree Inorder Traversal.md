### Binary Tree Inorder Traversal

> No.94, medium

Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree `[1,null,2,3]`,

```
   1
    \
     2
    /
   3
```

return `[1,3,2]`.

Note: Recursive solution is trivial, could you do it iteratively?

#### 分析

中序遍历算法的遍历次序是 “左-中-右”。

#### 实现

- 递归实现

```java
/**
 * 中序遍历（基于递归）
 *
 * @param root
 * @return
 */
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    this.recursion(root, result);
    return result;
}

/**
 * 递归的方法
 *
 * @param node
 * @param list
 */
public void recursion(TreeNode node, List<Integer> list) {
    if (null == node) return;
    if (null != node.left) this.recursion(node.left, list);
    list.add(node.val);
    if (null != node.right) this.recursion(node.right, list);
}
```

- 非递归实现

假设有输入节点 N （初始时 N = root），中序遍历非递归的思路如下：

> 1. 如果 N != null，则入栈，然后 N = N.left，循环直到 N == null 为止
> 2. 出栈，访问该节点 M
> 3. 如果 M 的右孩子节点为空，则继续出栈，否则令 N 为 M 的右孩子节点，回到步骤 1

```java
/**
 * 中序遍历（基于栈）
 *
 * @param root
 * @return
 */
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    while (null != root || !stack.isEmpty()) {
        // 循环将左孩子节点入栈
        while (root != null) {
            stack.add(root);
            root = root.left;
        }
        if (!stack.isEmpty()) {
            // 出栈访问该节点
            TreeNode node = stack.pop();
            result.add(node.val);
            // 令 root = node.right
            root = node.right;
        }
    }
    return result;
}
```