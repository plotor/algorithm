### Populating Next Right Pointers in Each Node II

> No.117, medium

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

- You may only use constant extra space.

For example, Given the following binary tree,

```
eg.
     1
   /  \
  2    3
 / \    \
4   5    7
```

After calling your function, the tree should look like:

```
eg.
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
```

#### 分析

相对于 I 来说，这里的二叉树是任意的，不一定是完全二叉树，所以存在跨多个 next 连线的情况，这道题目需要注意的一点是必须先处理右边，再处理左边，因为 next 指向右节点，所以在跨多个 next 时，必须保证右边的 next 是连通的。

#### 实现

```java
public class PopulatingNextRightPointersInEachNodeII {

    /**
     * 相对于 I 来说，这里的二叉树是任意的，不一定是完全二叉树
     * 所以存在跨多个 next 连线的情况，这道题目需要注意的一点
     * 是必须先处理右边，再处理左边，因为 next 指向右节点，所
     * 以在跨多个 next 时，必须保证右边的 next 是连通的
     *
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (null == root) return;
        // 先处理右孩子节点
        if (null != root.right) {
            TreeLinkNode node = root.next;
            while (null != node) {
                if (null == node.left && null == node.right) {
                    node = node.next;
                    continue;
                }
                root.right.next = null != node.left ? node.left : node.right;
                break;
            }
        }

        // 再处理左孩子节点
        if (null != root.left) {
            if (null != root.right) {
                root.left.next = root.right;
            } else {
                TreeLinkNode node = root.next;
                while (null != node) {
                    if (null == node.left && null == node.right) {
                        node = node.next;
                        continue;
                    }
                    root.left.next = null != node.left ? node.left : node.right;
                    break;
                }
            }
        }

        // 必须先处理右子树
        this.connect(root.right);
        this.connect(root.left);
    }

}
```