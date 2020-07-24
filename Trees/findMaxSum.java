package Trees;

import java.util.*;

/*
Write a function that takes in a Binary Tree and returns its max path sum
a path is a collection of connected nodes in a tree where no node is connected to more than two other node; 
a path sum is the sum of the values of the nodes in a particular path.
*/
public class findMaxSum {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static int maxPathSum(BinaryTree tree) {
        List<Integer> maxSumArray = findMaxSum(tree);
        return maxSumArray.get(1);
    }

    private static List<Integer> findMaxSum(BinaryTree tree) {
        if (tree == null) {
            return new ArrayList<Integer>(Arrays.asList(0, Integer.MIN_VALUE));
        }
        List<Integer> leftMaxSumArray = findMaxSum(tree.left);
        List<Integer> rightMaxSumArray = findMaxSum(tree.right);

        int leftMaxSumAsBranch = leftMaxSumArray.get(0);
        int leftMaxPathSum = leftMaxSumArray.get(1);

        int rightMaxSumAsBranch = rightMaxSumArray.get(0);
        int rightMaxPathSum = rightMaxSumArray.get(1);

        int maxChildSumAsBranch = Math.max(leftMaxSumAsBranch, rightMaxSumAsBranch);
        int maxSumAsBranch = Math.max(maxChildSumAsBranch + tree.value, tree.value);
        int maxSumAsRootNode = Math.max(leftMaxSumAsBranch + tree.value + rightMaxSumAsBranch, maxSumAsBranch);
        int maxPathSum = Math.max(leftMaxPathSum, Math.max(rightMaxPathSum, maxSumAsRootNode));

        return new ArrayList<Integer>(Arrays.asList(maxSumAsBranch, maxPathSum));
    }
}