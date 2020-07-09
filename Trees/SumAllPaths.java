package Trees;

import java.util.*;

public class SumAllPaths {
    /*
     * Variant 1: Root To Leaf Path Sum Give a binary tree and a target sum sum,
     * determine if there is a path from the root to a leaf that sums to the target
     * sum sum.
     */
    /*
     * Variant 1: Root to leaf path sum
     */
    public boolean hasPathSum(TreeNode node, int targetSum) {
        if (node == null)
            return false;

        if (node.left == null && node.right == null && node.val == targetSum)
            return true;

        return hasPathSum(node.left, targetSum - node.val) || hasPathSum(node.right, targetSum - node.val);
    }

    /*
     * Variant 2: All Paths With Sum
     */

    /* Brute force method */
    public int pathSum(TreeNode node, int targetSum) {
        if (node == null)
            return 0;

        return totalPathSumsFromThisNode(node, targetSum) + pathSum(node.left, targetSum)
                + pathSum(node.right, targetSum);
    }

    private int totalPathSumsFromThisNode(TreeNode node, int targetSum) {
        if (node == null)
            return 0;

        int totalCompletedPathsFromThisNode = (node.val == targetSum) ? 1 : 0;

        totalCompletedPathsFromThisNode += totalPathSumsFromThisNode(node.left, targetSum - node.val)
                + totalPathSumsFromThisNode(node.right, targetSum - node.val);

        return totalCompletedPathsFromThisNode;
    }

    /* Optimal Method */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        Map<Integer, Integer> prefixSumToTotalPrefixes = new HashMap<>();

        prefixSumToTotalPrefixes.put(0, 1);

        return findPathSum(root, 0, sum, prefixSumToTotalPrefixes);
    }

    private int findPathSum(TreeNode node, int rootToNodeSum, int target,
            Map<Integer, Integer> prefixSumToTotalPrefixes) {
        if (node == null)
            return 0;

        rootToNodeSum += node.val;

        int amountToCompensateFor = rootToNodeSum - target;
        int totalPathsEndingAtThisNode = prefixSumToTotalPrefixes.getOrDefault(amountToCompensateFor, 0);

        int totalPathsWithThisPathsSum = prefixSumToTotalPrefixes.getOrDefault(rootToNodeSum, 0);
        prefixSumToTotalPrefixes.put(rootToNodeSum, totalPathsWithThisPathsSum + 1);

        int totalCompletedPathsInThisSubtree = totalPathsEndingAtThisNode
                + findPathSum(node.left, rootToNodeSum, target, prefixSumToTotalPrefixes)
                + findPathSum(node.right, rootToNodeSum, target, prefixSumToTotalPrefixes);

        return totalCompletedPathsInThisSubtree;
    }
}