### Binary Tree Postorder Traversal

> No.145, hard

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree `{1,#,2,3}`,
```
   1
    \
     2
    /
   3
```
return `[3,2,1]`.

Note: Recursive solution is trivial, could you do it iteratively?

#### 分析

后序遍历算法的遍历次序是 “左-右-中”。

#### 实现

- 递归实现

```java
/**
 * 后序遍历（基于递归）
 *
 * @param root
 * @return
 */
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    this.recursion(root, result);
    return result;
}

private void recursion(TreeNode node, List<Integer> list) {
    if (null == node) return;
    if (null != node.left) this.recursion(node.left, list);
    if (null != node.right) this.recursion(node.right, list);
    list.add(node.val);
}
```
- 非递归实现

后序遍历的非递归实现属于三种遍历中最复杂的一种，某一个点被访问的条件是：

> 1. 该节点没有孩子节点  
> 或  
> 2. 该节点的孩子节点已经被访问过

所以我们需要利用一个变量来记录上一次被访问的节点，令该变量为 pre，则算法思路如下：

> 1. 根结点入栈
> 2. peek 栈顶元素，如果该节点满足上述两个条件之一，则 pop 栈顶元素并访问该节点，并记录到 pre 变量
> 3. 如果 不满足，则先判断如果右孩子不为空，则入栈，然后判断如果左孩子不为空，则入栈
> 4. 返回步骤 2，重复执行，直到栈为空为止

```java
/**
 * 后序遍历（基于栈）
 *
 * @param root
 * @return
 */
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    Stack<TreeNode> stack = new Stack<TreeNode>();
    if (null != root) stack.add(root); // 现将根节点入栈
    TreeNode pre = null;
    while (!stack.isEmpty()) {
        TreeNode node = stack.peek();
        /*
         * 1. 当前节点没有孩子节点
         * 2. 当前节点的孩子节点是上次访问的节点
         */
        if ((null == node.left && null == node.right)
                || (null != pre && (pre == node.right || pre == node.left))) {
            stack.pop();
            result.add(node.val);
            pre = node;
        } else {
            // 需要先右再左
            if (null != node.right) stack.add(node.right);
            if (null != node.left) stack.add(node.left);
        }
    }
    return result;
}
```
