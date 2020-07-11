package Trees;

import java.util.*;
/*
Given a sorted array, create a binary search tree with minimal height. 
*/

public class MinHeightTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return BuildTree(nums, 0, nums.length);
    }

    private TreeNode BuildTree(int[] nums, int left, int right) {
        if (left >= right)
            return null;

        int midleIndex = left + (right - left) / 2;

        TreeNode newTree = new TreeNode(nums[midleIndex]);
        newTree.left = BuildTree(nums, left, midleIndex);
        newTree.right = BuildTree(nums, midleIndex + 1, right);

        return newTree;
    }
}