package trees;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintLeafNodes {
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private void printLeafs(TreeNode root) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            logger.log(Level.INFO, "{0}", root.data);
        }

        if (root.left != null)
            printLeafs(root.left);

        if (root.right != null)
            printLeafs(root.right);
    }

    public static void main(String[] args) {
        TreeNode node10 = new TreeNode(10);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, null, node10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, node9, null);
        TreeNode node4 = new TreeNode(4, node8, null);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        new PrintLeafNodes().printLeafs(node1);
    }
}
