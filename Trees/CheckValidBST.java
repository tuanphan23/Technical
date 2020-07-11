package Trees;

import java.util.*;
/*
Given a binary tree, return whether is a valid binary search tree(BST) or not.
 
Valid BST is defined as:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/

public class CheckValidBST {
    /* brute force method */
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, int min, int max) {
        if (node == null)
            return true;
        else if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    /* Breadth first search */
    public boolean isValidBST2(TreeNode root) {
        Queue<AugmentedTreeNode> queue = new LinkedList<AugmentedTreeNode>();
        queue.add(new AugmentedTreeNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            AugmentedTreeNode augmentedNode = queue.poll();
            if (augmentedNode != null) {
                int nodeVal = augmentedNode.node.val;
                if (nodeVal <= augmentedNode.min || nodeVal >= augmentedNode.max)
                    return false;

                queue.add(new AugmentedTreeNode(augmentedNode.node.left, augmentedNode.min, nodeVal));
                queue.add(new AugmentedTreeNode(augmentedNode.node.right, nodeVal, augmentedNode.max));
            }
        }
        return true;
    }

    private class AugmentedTreeNode {
        TreeNode node;
        int min, max;

        public AugmentedTreeNode(TreeNode node, int min, int max) {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}