package trees;

public class BinaryTree {

    TreeNode root = null;

    public void addTreeNode(TreeNode node) {
        TreeNode temp = root;

        if(root == null) {
            root = node;
            return;
        }
        TreeNode pre = null;
        while(temp != null) {
            pre = temp;
            if(temp.data > node.data) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }

        if(pre.data < node.data) {
            pre.right = node;
        } else {
            pre.left = node;
        }
        return;
    }

    public void printTree() {
        printTree(root);
    }
    public static void printTree(TreeNode node) {

        if(node == null)
            return ;
        printTree(node.left);
        System.out.print(node.data+" ");
        printTree(node.right);
    }
}
