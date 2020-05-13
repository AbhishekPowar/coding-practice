package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeftView {

    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private int maxLevel = 0;
    private static Queue<TreeNode> queue = new LinkedList<>();

    public void printLeftView(TreeNode node) {
        printLeftView(node, 1);
    }

    private void printLeftView(TreeNode node, int level) {

        if(node == null)
            return;

        if(level > maxLevel) {
            logger.log(Level.INFO, "{0} ", node.val);
            maxLevel = level;
        }

        printLeftView(node.left, level+1);
        printLeftView(node.right, level+1);
    }

    public void printLeftViewLOT(TreeNode node) {
        if(node == null)
            return;

        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.peek();
            if(curr != null) {
                logger.log(Level.INFO, "{0} ", curr.val);
                while(queue.peek() != null) {
                    if(curr.left != null)
                        queue.add(curr.left);
                    if(curr.right != null)
                        queue.add(curr.right);

                    queue.remove();
                    curr = queue.peek();
                }
                queue.add(null);
            }
            queue.remove();
        }

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

        TreeNode root = node1;

        new LeftView().printLeftView(root);
        new LeftView().printLeftViewLOT(root);
    }
}
