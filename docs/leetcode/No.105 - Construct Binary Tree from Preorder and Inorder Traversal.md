### Construct Binary Tree from Preorder and Inorder Traversal

> No.105, medium

Given preorder and inorder traversal of a tree, construct the binary tree.

Note:  
You may assume that duplicates do not exist in the tree.

#### 分析

我们可以基于先序遍历和中序遍历推导出对应的二叉树，或者根据中序遍历和后序遍历推导出对应的数，而不能根据先序遍历和后续遍历来推导出对应的二叉树，即不能跨顺序。

#### 实现

```java
public TreeNode buildTree(int[] preorder, int[] inorder) {
    if (null == preorder || null == inorder) return null;
    return this.build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
}

private TreeNode build(int[] po, int pol, int por, int[] io, int iol, int ior) {
    if (pol > por || iol > ior) return null;
    TreeNode node = new TreeNode(po[pol]);
    // 寻找左右子树的root节点位置
    int k = iol;
    for (int i = iol; i <= ior; i++) {
        if (io[i] == po[pol]) {
            k = i;
            break;
        }
    }
    node.left = this.build(po, pol + 1, pol + k - iol, io, iol, k - 1);
    node.right = this.build(po, pol + k - iol + 1, por, io, k + 1, ior);
    return node;
}
```