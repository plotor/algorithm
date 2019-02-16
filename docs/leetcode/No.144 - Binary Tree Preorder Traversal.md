### Binary Tree Preorder Traversal

> No.144, medium

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree `{1,#,2,3}`,

```
   1
    \
     2
    /
   3
```

return `[1,2,3]`.

Note: Recursive solution is trivial, could you do it iteratively?

#### 分析

前序遍历算法的遍历次序是 “中-左-右”。

#### 实现

- 递归实现

```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    this.recursion(root, result);
    return result;
}

private void recursion(TreeNode node, List<Integer> list) {
    if (null == node) return;
    list.add(node.val);
    if (null != node.left) this.recursion(node.left, list);
    if (null != node.right) this.recursion(node.right, list);
}
```

- 非递归实现

先序遍历的非递归实现属于三种遍历中最简单的一种，因为双亲节点需要第一个被访问，所以依赖于栈，基本的算法流程是：

> 1. 根结点入栈
> 2. 出栈，访问该节点 N
> 3. 如果 N 的右孩子节点不为空，则入栈
> 4. 如果 N 的左孩子节点不为空，则入栈
> 5. 如果栈不为空，则返回步骤 2

```java
/**
 * 非递归（基于栈）
 *
 * @param root
 * @return
 */
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (null != root) stack.add(root);  // 根节点入栈
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        if (null != node.right) stack.add(node.right); // 先右孩子节点入栈
        if (null != node.left) stack.add(node.left); // 再左孩子节点入栈
    }
    return result;
}
```