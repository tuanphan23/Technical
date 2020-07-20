package Trees;

import java.util.*;
/*
Given a binary tree and an integer value x, return the inorder successor of the node with value x.

In-order Successors:
The in-order successor of a node in binary tree is defined to be the next node in the in-order traversal of the Binary Tree.

*/

public class InorderSuccessor {
    public TreeNode inorderSuccessor(TreeNode node, int x) {
        if (node != null) {
            if (Integer.parseInt(node.val) == x) {
                return inorderSuccessorHelper(node);
            }
        }

        TreeNode lhs = inorderSuccessor(node.left, x);
        TreeNode rhs = inorderSuccessor(node.right, x);

        if (lhs != null)
            return lhs;
        else if (rhs != null)
            return rhs;

        return null;
    }

    private TreeNode inorderSuccessorHelper(TreeNode node) {
        TreeNode searchPointer = node;

        if (searchPointer.right != null) {
            searchPointer = searchPointer.right;
            while (searchPointer.left != null) {
                searchPointer = searchPointer.left;
            }
            return searchPointer;
        }

        while (searchPointer.parent != null && searchPointer.parent.right == searchPointer) {
            searchPointer = searchPointer.parent;
        }

        return searchPointer.parent;
    }

    private class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;

        TreeNode(String x) {
            val = x;
        }
    }
}