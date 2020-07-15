package Trees;

public class BSTInsertionDeletion {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode mostRecentRightNode = new TreeNode(getMostRecentRightNode(root.right));
            root.val = mostRecentRightNode.val;

            root.right = deleteNode(root.right, mostRecentRightNode.val);

        }
    }

    private TreeNode getMostRecentRightNode(TreeNode root) {
        if (root == null)
            return null;

        TreeNode curr = root;
        while (curr != null)
            curr = curr.left;
        return curr;
    }
}