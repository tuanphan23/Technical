package Trees;

/*
Given the root of a binary search tree root and the value of two nodes x and y, 
return a reference to their lowest common ancestor.
*/
public class LowestCommonAncestor {
    public TreeNode LowestCommonAncestor(TreeNode root, int x, int y) {
        if (x < root.val && y < root.val) {
            return LowestCommonAncestor(root.left, x, y);
        }
        if (x > root.val && y > root.val) {
            return LowestCommonAncestor(root.right, x, y);
        }
        return root;
    }
}