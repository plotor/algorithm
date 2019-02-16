### Binary Tree Paths

> No.257, easy

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

```
eg.
   1
 /   \
2     3
 \
  5
```

All root-to-leaf paths are:

```
["1->2->5", "1->3"]
```

#### 分析

题目要求返回二叉树所有从根结点到叶子结点的路径。

#### 实现

```java
private List<String> result = new ArrayList<String>();

public List<String> binaryTreePaths(TreeNode root) {
    if(null == root) return result;
    this.preOrderTraversal(root, new ArrayList<Integer>());
    return result;
}

private void preOrderTraversal(TreeNode node, List<Integer> list) {
    list.add(node.val);
    if (null == node.left && null == node.right) {
        result.add(this.join(new ArrayList<Integer>(list)));
        return;
    }

    if (null != node.left) {
        this.preOrderTraversal(node.left, list);
        list.remove(list.size() - 1);
    }
    if (null != node.right) {
        this.preOrderTraversal(node.right, list);
        list.remove(list.size() - 1);
    }
}

private String join(List<Integer> list) {
    StringBuilder sb = new StringBuilder();
    for (final Integer val : list) {
        sb.append(val + "->");
    }
    return sb.substring(0, sb.length() - 2);
}
```
