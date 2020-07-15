package Trees;

import java.util.*;
/*
Given a binary tree, populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL. 
*/

public class LinkedTreeNode {
    /* perfect tree */
    public LinkedTreeNode connect(LinkedTreeNode root) {
        if (root == null)
            return null;

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null && root.next != null) {
            root.right.next = root.next.left;
        }
        root.left = connect(root.left);
        root.right = connect(root.right);

        return root;
    }

    /* not perfect tree */
    public LinkedTreeNode connect(LinkedTreeNode root) {
        if (root == null)
            return null;

        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                root.left.next = findNextNode(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = findNextNode(root.next);
        }

        root.left = connect(root.left);
        root.right = connect(root.right);

        return root;
    }

    private LinkedTreeNode findNextNode(LinkedTreeNode root) {
        if (root == null)
            return null;
        if (root.left != null)
            return root.left;
        if (root.right != null)
            return root.right;

        return findNextNode(root.next);
    }
}