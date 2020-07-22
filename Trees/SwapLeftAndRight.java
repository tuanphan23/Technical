package Trees;

import java.util.*;

/*
Write a function that takes in a Binary Tree and inverts it. The function should swap every left node in the tree
for its corresponding right node.
Each BinaryTree node has an integer value, a left child node, and a right child node. 
Children nodes can either be BinaryTree nodes themselves or None/Null
*/

public class SwapLeftAndRight {
    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if (tree == null)
            return;
        swap(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    private static void swap(BinaryTree tree) {
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;
    }
}