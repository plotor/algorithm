### Two Sum IV - Input is a BST

> No.653, easy

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

```text
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

Example 2:

```text
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

#### 分析

这道题虽然输入的是一个 BST，但是核心解题思路还是不变的，可以基于中序遍历获取 BST 对应的有序集合，然后关联到 Two Sum 的基本解法。

#### 实现

```java
public boolean findTarget(TreeNode root, int k) {
    if (null == root) return false;
    List<Integer> list = new ArrayList<Integer>();
    this.inorderTraversal(root, list);
    int i = 0, j = list.size() - 1;
    while (i < j) {
        int sum = list.get(i) + list.get(j);
        if (sum == k) {
            return true;
        } else if (sum < k) {
            i++;
        } else {
            j--;
        }
    }
    return false;
}

/**
 * 中序遍历获取有序集合
 *
 * @param node
 * @param list
 */
private void inorderTraversal(TreeNode node, List<Integer> list) {
    if (null != node.left) {
        this.inorderTraversal(node.left, list);
    }
    list.add(node.val);
    if (null != node.right) {
        this.inorderTraversal(node.right, list);
    }
}
```