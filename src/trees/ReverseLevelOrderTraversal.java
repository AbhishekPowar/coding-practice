package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {

    Stack<TreeNode> stack = new Stack<>();
    Queue<TreeNode> queue = new LinkedList<>();

    public void printRLOT(TreeNode node) {
        if(node == null)
            return;

        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.peek();
            stack.push(curr);
            if(curr.right != null)
                queue.add(curr.right);
            if(curr.left != null)
                queue.add(curr.left);

            queue.remove();
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.peek().data+" ");
            stack.pop();
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

        new ReverseLevelOrderTraversal().printRLOT(root);
    }
}
