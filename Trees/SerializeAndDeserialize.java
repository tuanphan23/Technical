package Trees;

import java.util.*;
/*
Implement two functions:
serialize(Node root): Takes the root of a binary tree and returns a string representation of the tree
deserialize(String serialization): Takes the serialization from our first function and returns the same binary tree first input to serialize(Node root)
*/

public class SerializeAndDeserialize {
    public String serialize(TreeNode root) {
        if (root == null)
            return "X,";
        String leftSerialize = serialize(root.left);
        String rightSerialize = serialize(root.right);
        return root.val + "," + leftSerialize + rightSerialize;
    }

    public TreeNode deserialize(String data) {
        Queue<String> nodesLeft = new LinkedList<>();
        nodesLeft.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(nodesLeft);
    }

    private TreeNode deserializeHelper(Queue<String> nodesLeft) {
        String nodeValue = nodesLeft.poll();
        if (nodeValue == "X")
            return null;

        TreeNode node = new TreeNode(Integer.valueOf(nodeValue));

        node.left = deserializeHelper(nodesLeft);
        node.right = deserializeHelper(nodesLeft);

        return node;
    }
}