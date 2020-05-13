package trees;

import java.util.Stack;

public class LevelOrderSpiralTraversal {

    private void LOT(TreeNode node) {

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                TreeNode n = s1.pop();

                System.out.print(n.val +" ");

                if(n.right != null)
                    s2.push(n.right);
                if(n.left != null)
                    s2.push(n.left);
            }

            while(!s2.isEmpty()) {
                TreeNode n = s2.pop();

                System.out.print(n.val +" ");

                if(n.left != null)
                    s1.push(n.left);
                if(n.right != null)
                    s1.push(n.right);
            }
        }
    }
    public static void main(String[] args) {

        TreeNode root;

        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node7, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        root = node1;

        new LevelOrderSpiralTraversal().LOT(root);


        System.out.println("abc".compareTo("acb"));

    }
}
