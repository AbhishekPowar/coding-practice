package trees;

import java.util.Stack;

/**
 *
 */
public class LevelOrderSpiral {
    /**
     * Two Stack solution
     * @param node
     */
    public void spiralTraversalTwoStack(TreeNode node) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode n = s1.pop();

                System.out.print(n.data+" ");

                if(n.right != null)
                    s2.push(n.right);
                if(n.left != null)
                    s2.push(n.left);
            }
            while(!s2.isEmpty()) {
                TreeNode n = s2.pop();

                System.out.print(n.data+" ");

                if(n.left != null)
                    s1.push(n.left);
                if(n.right != null)
                    s1.push(n.right);
            }

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


        BinaryTree.printTree(root);
        System.out.println();
        new LevelOrderSpiral().spiralTraversalTwoStack(root);


    }
}
