package trees;

public class RightView {

    private static int maxLevel = 0;

    public void printRightView(TreeNode node) {
        printRightView(node, 1);
    }

    private void printRightView(TreeNode node, int level) {

        if(node == null)
            return;

        if(level > maxLevel) {
            System.out.print(node.val +" ");
            maxLevel = level;
        }

        printRightView(node.right, level+1);
        printRightView(node.left, level+1);
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

        new RightView().printRightView(root);
    }
}
