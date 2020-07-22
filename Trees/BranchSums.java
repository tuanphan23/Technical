package Trees;

import java.util.*;
/*
Write a function that takes in a Binary Tree and returns a list of its branch sums ordered from leftmost branch sum to
rightmost branch sum.
A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path of nodes in a tree that starts
at the root node and ends at any leaf node.
Each Binary Tree node has an integer value, a left child node, and a right child node. Children nodes can either be BinaryTree
nodes themselves or None/null.
*/

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        calculateBranchSums(root, 0, result);
        return result;
    }

    private static void calculateBranchSums(BinaryTree node, int currentSum, List<Integer> result) {
        if (node == null)
            return;
        int finalSum = 0;
        finalSum = currentSum + node.value;
        calculateBranchSums(node.left, finalSum, result);
        calculateBranchSums(node.right, finalSum, result);
        if (node.left == null && node.right == null) {
            result.add(finalSum);
            return;
        }
    }
}