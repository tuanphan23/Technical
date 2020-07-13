package Trees;

import java.util.*;

/*
Given the root node to a binary tree, determine the longest path that exists between any two nodes in the tree.
*/
public class LongestPath {
    public int diameterOfBinaryTree(TreeNode root) {
        RecursiveAnswer finalAnswer = subTreeMaxDiameter(root);
        return finalAnswer.diameter;
    }

    private RecursiveAnswer subTreeMaxDiameter(TreeNode root) {
        if (root == null)
            return new RecursiveAnswer(0, 0);

        RecursiveAnswer left = subTreeMaxDiameter(root.left);
        RecursiveAnswer right = subTreeMaxDiameter(root.right);

        int maxLeftOrRightDiameter = Math.max(left.diameter, right.diameter);
        int maxDiameter = Math.max(maxLeftOrRightDiameter, left.height + right.height);
        int height = Math.max(left.height, right.height) + 1;

        return new RecursiveAnswer(maxDiameter, height);
    }

    private class RecursiveAnswer {
        int diameter;
        int height;

        public RecursiveAnswer(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }
}