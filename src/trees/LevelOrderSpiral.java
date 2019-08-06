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
    public void spiralTraversalTwoStack(Node node) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.push(node);

        while(!s1.isEmpty() || !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                Node n = s1.pop();

                System.out.print(n.data+" ");

                if(n.right != null)
                    s2.push(n.right);
                if(n.left != null)
                    s2.push(n.left);
            }
            while(!s2.isEmpty()) {
                Node n = s2.pop();

                System.out.print(n.data+" ");

                if(n.left != null)
                    s1.push(n.left);
                if(n.right != null)
                    s1.push(n.right);
            }

        }
    }

    public static void main(String[] args) {

        Node node10 = new Node(10);
        Node node9 = new Node(9);
        Node node8 = new Node(8);
        Node node7 = new Node(7, null, node10);
        Node node6 = new Node(6);
        Node node5 = new Node(5, node9, null);
        Node node4 = new Node(4, node8, null);
        Node node3 = new Node(3, node6, node7);
        Node node2 = new Node(2, node4, node5);
        Node node1 = new Node(1, node2, node3);

        Node root = node1;


        BinaryTree.printTree(root);
        System.out.println();
        new LevelOrderSpiral().spiralTraversalTwoStack(root);


    }
}
