package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    public void printLOTIterative(TreeNode node) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            System.out.print(curr.data+" ");

            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        System.out.println();
    }
    public void printLOTRecursive(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        printLOTRecursive(queue);

    }

    private void printLOTRecursive(Queue<TreeNode> queue) {
        if(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.data+" ");

            if(node.left != null)
                queue.add(node.left);
            if(node.right != null)
                queue.add(node.right);

            printLOTRecursive(queue);
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

        new LevelOrderTraversal().printLOTIterative(root);
        new LevelOrderTraversal().printLOTRecursive(root);
    }

}
