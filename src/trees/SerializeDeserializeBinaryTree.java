package trees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "X";

        String leftSerialized = serialize(root.left);
        String rightSerialized = serialize(root.right);

        return root.data + "," + leftSerialized + "," + rightSerialized;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> nodes) {
        String valueForNode = nodes.poll();
        if(valueForNode.equals("X"))
            return null;
        TreeNode node = new TreeNode(Integer.parseInt(valueForNode));
        node.left = helper(nodes);
        node.right = helper(nodes);

        return node;
    }


    public static void main(String[] args) {
        int[][] ar = new int[2][3];

        System.out.println(ar.length+","+ar[0].length);
    }
}
