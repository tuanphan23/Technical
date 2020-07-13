package Trees;

import java.util.*;

import javax.swing.tree.TreeNode;

/*
Given a binary tree as input, return its inorder traversal.
*/
public class InOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderList = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            inorderList.add(curr.val);
            curr = curr.right;
        }
        return inorderList;
    }
}