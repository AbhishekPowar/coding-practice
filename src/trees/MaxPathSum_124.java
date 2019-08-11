package trees;

public class MaxPathSum_124 {

    private int maxAll = -9999;

    private int maxSum(TreeNode root) {

        if(root == null)
            return -9999;

        if(root.left == null && root.right == null)
            return root.data;

        int left = maxSum(root.left);
        int right = maxSum(root.right);

        int total = left + right + root.data;
        int maxChild = Math.max(left, right);

        int max = Math.max(root.data, Math.max(total, Math.max(maxChild, maxChild+root.data)));

        maxAll = Math.max(max, maxAll);

        return Math.max(Math.max(left+ root.data, right + root.data), root.data);

    }
    public int maxPathSum(TreeNode root) {
        return Math.max(maxAll, maxSum(root));
    }

    public static void main(String[] args) {
        MaxPathSum_124 maxPathSum_124 = new MaxPathSum_124();

        TreeNode root;

        TreeNode node1 = new TreeNode(-1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1, node1, null);
        TreeNode node5 = new TreeNode(-3, node2, null);
        TreeNode node6 = new TreeNode(-2, node4, node3);
        TreeNode node = new TreeNode(1, node6, node5);

        root = node;
        System.out.println(maxPathSum_124.maxPathSum(root));
    }
}
