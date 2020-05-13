package trees;

public class FixBST {

    private TreeNode prev = null;

    public void fix(TreeNode root) {
        helper(root);
    }

    private void helper(TreeNode root) {
        if(root != null) {
            helper(root.left);

            if(prev != null && prev.val > root.val) {
                swap(prev, root);
            }
            prev = root;

            helper(root.right);
        }
    }
    public void swap(TreeNode node1, TreeNode node2) {
        int v = node1.val;
        node1.val = node2.val;
        node2.val = v;
    }

    public static void printInorder(TreeNode root) {
        if(root == null)
            return;

        printInorder(root.left);
        System.out.print(root.val +" ");
        printInorder(root.right);

    }
    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node1 = new TreeNode(1, node2, node3);
//        TreeNode node4 = new TreeNode(4, node2, null);


        printInorder(node1);
        new FixBST().fix(node1);
        System.out.println();
        printInorder(node1);

    }
}
