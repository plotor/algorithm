package org.zhenchao.algorithm.oj.leetcode.medium;

import org.apache.commons.lang3.StringUtils;
import org.zhenchao.algorithm.oj.TreeNode;
import org.zhenchao.algorithm.util.TreeNodeUtils;

import java.util.List;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 *
 * @author zhenchao.wang 2017-07-18 21:53
 * @version 1.0.0
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

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

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal cbt = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder = {4, 2, 5, 1, 6, 7, 3};
        TreeNode root = cbt.buildTree(preorder, inorder);
        List<Integer> result = TreeNodeUtils.preorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
        result = TreeNodeUtils.inorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
        result = TreeNodeUtils.postorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
    }

}
