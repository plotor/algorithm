### Populating Next Right Pointers in Each Node

> Mo.116, medium

Given a binary tree

```
struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
```

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to `NULL`.

Initially, all next pointers are set to `NULL`.

Note:

- You may only use constant extra space.  
- You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example, Given the following perfect binary tree,

```
eg.
     1
   /  \
  2    3
 / \  / \
4  5  6  7
```

After calling your function, the tree should look like:

```
eg.
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
```

### 分析

题目要求给定一棵完全二叉树，然后将所有的结点的右指针指向当前结点所在层次右边的结点，如果没有的话则为 `NULL`，我们可以选择先序遍历，每一次都处理当前结点的孩纸结点。

### 实现

```java
public class Solution {
    /**
     * root 是一棵完全二叉树
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (null == root) return;
        if (null != root.right) {
            root.left.next = root.right;
            if (null != root.next) {
                root.right.next = root.next.left;
            }
        }
        this.connect(root.left);
        this.connect(root.right);
    }
}
```