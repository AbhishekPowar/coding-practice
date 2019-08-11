package trees;

/**
 * @since 6/Aug/2019
 */
public class LowerCommonAncestor {

    private TreeNode LCA(TreeNode TreeNode, TreeNode n1, TreeNode n2) {

        if(TreeNode == null)
            return null;

        if(TreeNode.data == n1.data)
            return TreeNode;
        if(TreeNode.data == n2.data)
            return TreeNode;

        TreeNode leftSubTreeResult = LCA(TreeNode.left, n1, n2);
        TreeNode rightSubTreeResult = LCA(TreeNode.right, n1, n2);

        if(leftSubTreeResult == null && rightSubTreeResult == null)
            return null;
        if(leftSubTreeResult != null && rightSubTreeResult != null)
            return TreeNode;

        return leftSubTreeResult != null ? leftSubTreeResult:rightSubTreeResult;

    }
    public static void main(String[] args) {
        TreeNode TreeNode10 = new TreeNode(10);
        TreeNode TreeNode9 = new TreeNode(9);
        TreeNode TreeNode8 = new TreeNode(8);
        TreeNode TreeNode7 = new TreeNode(7, null, TreeNode10);
        TreeNode TreeNode6 = new TreeNode(6);
        TreeNode TreeNode5 = new TreeNode(5, TreeNode9, null);
        TreeNode TreeNode4 = new TreeNode(4, TreeNode8, null);
        TreeNode TreeNode3 = new TreeNode(3, TreeNode6, TreeNode7);
        TreeNode TreeNode2 = new TreeNode(2, TreeNode4, TreeNode5);
        TreeNode TreeNode1 = new TreeNode(1, TreeNode2, TreeNode3);

        TreeNode root = TreeNode1;

        TreeNode lca = new LowerCommonAncestor().LCA(root, TreeNode4, TreeNode5);
        System.out.println(lca == null? "Not Found":lca.data);
    }
}
