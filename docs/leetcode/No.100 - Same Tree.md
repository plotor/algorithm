### Same Tree

> No.100, easy

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.

#### 分析

题目要求判断两棵树是否相同，基本思路都是对两个树同时进行遍历，然后比较对应的结点是否都存在，且值相等。

#### 实现

- 先序遍历

```java
/**
 * 递归的方式，同时先序遍历两个树
 *
 * @param p
 * @param q
 * @return
 */
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
        return true;
    } else if (p == null) {
        return false;
    } else if (q == null) {
        return false;
    } else if (p.val != q.val) {
        return false;
    } else {
        return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
    }
}
```

- 层序遍历

```java
/**
 * 非递归的方法，采用层次遍历
 *
 * @param p
 * @param q
 * @return
 */
public boolean isSameTreeNonRecursive(TreeNode p, TreeNode q) {
    Queue<TreeNode> pQueue = new LinkedList<TreeNode>();
    Queue<TreeNode> qQueue = new LinkedList<TreeNode>();
    pQueue.add(p);
    qQueue.add(q);
    while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
        TreeNode pnode = pQueue.poll();
        TreeNode qnode = qQueue.poll();
        if (pnode != null && qnode == null) {
            return false;
        } else if (pnode == null && qnode != null) {
            return false;
        } else if (pnode == null && qnode == null) {
            continue;
        } else if (pnode.val != qnode.val) {
            return false;
        } else {
            pQueue.offer(pnode.left);
            pQueue.offer(pnode.right);
            qQueue.offer(qnode.left);
            qQueue.offer(qnode.right);
        }
    }

    if (!pQueue.isEmpty() || !qQueue.isEmpty()) {
        return false;
    }

    return true;
}
```