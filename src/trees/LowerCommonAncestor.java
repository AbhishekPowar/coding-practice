package trees;

/**
 * @since 6/Aug/2019
 */
public class LowerCommonAncestor {

    private Node LCA(Node node, Node n1, Node n2) {

        if(node == null)
            return null;

        if(node.data == n1.data)
            return node;
        if(node.data == n2.data)
            return node;

        Node leftSubTreeResult = LCA(node.left, n1, n2);
        Node rightSubTreeResult = LCA(node.right, n1, n2);

        if(leftSubTreeResult == null && rightSubTreeResult == null)
            return null;
        if(leftSubTreeResult != null && rightSubTreeResult != null)
            return node;

        return leftSubTreeResult != null ? leftSubTreeResult:rightSubTreeResult;

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

        Node lca = new LowerCommonAncestor().LCA(root, node4, node5);
        System.out.println(lca == null? "Not Found":lca.data);
    }
}
