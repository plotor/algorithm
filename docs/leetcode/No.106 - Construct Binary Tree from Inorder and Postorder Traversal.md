### Construct Binary Tree from Inorder and Postorder Traversal

> No.106, medium

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:  
You may assume that duplicates do not exist in the tree.

#### 分析

我们可以基于先序遍历和中序遍历推导出对应的二叉树，或者根据中序遍历和后序遍历推导出对应的数，而不能根据先序遍历和后续遍历来推导出对应的二叉树，即不能跨顺序。

#### 实现

```java
public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (null == inorder || null == postorder) return null;
    return this.build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
}

private TreeNode build(int[] io, int iol, int ior, int[] po, int pol, int por) {
    if (iol > ior || pol > por) return null;
    TreeNode node = new TreeNode(po[por]);
    int k = iol;
    for (int i = iol; i <= ior; i++) {
        if (io[i] == po[por]) {
            k = i;
            break;
        }
    }
    node.left = this.build(io, iol, k - 1, po, pol, pol + k - iol - 1);
    node.right = this.build(io, k + 1, ior, po, pol + k - iol, por - 1);
    return node;
}
```