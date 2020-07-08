package Trees;

/*
Given a binary tree, test if it is symmetric both in value and in structure.
*/

public class SymmetricBinaryTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return CheckSymmetric(root.left, root.right);
    }

    private boolean CheckSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;

        if (left != null && right != null) {
            return (left.val == right.val) && CheckSymmetric(left.left, right.right)
                    && CheckSymmetric(left.right, right.left);
        }
        return false;
    }
}