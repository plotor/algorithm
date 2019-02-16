package org.zhenchao.algorithm.oj.leetcode.medium;

import org.apache.commons.lang3.StringUtils;
import org.zhenchao.algorithm.oj.TreeNode;
import org.zhenchao.algorithm.util.TreeNodeUtils;

import java.util.List;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 *
 * @author zhenchao.wang 2017-07-23 14:33
 * @version 1.0.0
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

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

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal cbt = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        int[] inorder = {4, 2, 5, 1, 6, 7, 3};
        int[] postorder = {4, 5, 2, 7, 6, 3, 1};
        TreeNode root = cbt.buildTree(inorder, postorder);
        List<Integer> result = TreeNodeUtils.preorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
        result = TreeNodeUtils.inorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
        result = TreeNodeUtils.postorderTraversal(root);
        System.out.println(StringUtils.join(result, ", "));
    }

}
