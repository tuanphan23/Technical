package Trees;

import java.util.*;
/*
Given the preorder and inorder traversals of a tree, construct the binary tree.
*/

public class TreeReconstruction {
    int preorderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderNodeToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderNodeToIndex.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, inorder.length - 1, inorderNodeToIndex);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end,
            Map<Integer, Integer> inorderNodeToIndex) {
        if (start > end)
            return null;
        int nodeValue = preorder[preorderIndex];
        TreeNode node = new TreeNode(nodeValue);
        preorderIndex++;
        if (start == end) {
            return node;
        }
        int inorderIndex = inorderNodeToIndex.get(nodeValue);
        node.left = build(preorder, inorder, start, inorderIndex - 1, inorderNodeToIndex);
        node.right = build(preorder, inorder, inorderIndex + 1, end, inorderNodeToIndex);

        return node;
    }
}