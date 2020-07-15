package Trees;

import java.util.*;

/*
A binary tree is "height-balanced" if at every node the left and right subtree height do not differ by more than 1.

Given a binary tree, determine if it is height-balanced.
*/
public class HeightBalancedTree {
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }

    private checkBalanceTree checkBalance(TreeNode root) {
        if (root == null) {
            return new checkBalanceTree(-1, true);
        }

        checkBalanceTree leftSubtree = checkBalance(root.left);
        checkBalanceTree rightSubtree = checkBalance(root.right);

        if (!leftSubtree.isBalanced)
            return leftSubtree;
        if (!rightSubtree.isBalanced)
            return rightSubtree;

        boolean isBalanced = Math.abs(leftSubtree.height - rightSubtree.height) <= 1;
        int height = Math.max(leftSubtree.height, rightSubtree.height) + 1;

        return new checkBalanceTree(height, isBalanced);
    }

    private class checkBalanceTree {
        int height;
        boolean isBalanced;

        public checkBalanceTree(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
}