package trees;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Program to find diameter of a tree
 *
 * @link <a>https://www.geeksforgeeks.org/diameter-of-a-binary-tree/</a>
 */
public class DiameterOfTree {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private int diameter(TreeNode root) {
        if (root == null)
            return 0;

        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight + rightHeight + 1, Math.max(leftDiameter, rightDiameter));

    }

    public int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftHeight = height(node.left) + 1;
        int rightHeight = height(node.right) + 1;

        return Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode node11 = new TreeNode(11);
        TreeNode node10 = new TreeNode(10, null, node11);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, null, node10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node9, null);
        TreeNode node4 = new TreeNode(4, node8, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        TreeNode root = node1;

        DiameterOfTree diameterOfTree = new DiameterOfTree();
        logger.log(Level.INFO, "Diameter of Tree: {0}", diameterOfTree.diameter(root));
    }
}
