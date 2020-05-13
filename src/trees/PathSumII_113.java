package trees;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {
    public List<List<Integer>> paths = new ArrayList<>();

    private List<List<Integer>> getPathSum(TreeNode node, int sum) {

        getPaths(node, sum, new ArrayList<>());
        return null;
    }

    private boolean pathSumExists(TreeNode node, int sum) {
        if(node == null)
            return false;
        if(node.left == null && node.right == null && node.val == sum)
            return true;

        List<Integer> list = new ArrayList<>();
        list.add(node.val);

        if(pathSumExists(node.left, sum - node.val)) {
            list.add(node.left.val);
        }

        if(pathSumExists(node.right, sum - node.val)) {
            list.add(node.right.val);
        }
        return pathSumExists(node.left, sum - node.val) || pathSumExists(node.right, sum - node.val);
    }

    private void getPaths(TreeNode node, int sum, List<Integer> path) {
        if(node == null)
            return;

        path.add(node.val);

        if(node.left == null && node.right == null && node.val == sum) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size() -1 );
            return;
        }

        getPaths(node.left, sum - node.val, path);
        getPaths(node.right, sum - node.val, path);
        path.remove(path.size() - 1);
    }
    private int pathCount(TreeNode node, int sum) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null && node.val == sum)
            return 1;

        return pathCount(node.left, sum - node.val) + pathCount(node.right, sum - node.val);
    }
    public static void main(String[] args) {

        TreeNode root;

        TreeNode node7 = new TreeNode(10);
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node7, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        root = node1;

        /**
         *      1
         *    2    3
         *  4  5  9
         *      6
         */

        PathSumII_113 l = new PathSumII_113();
//        System.out.println(new PathSumII_113().pathCount(root, 7));
//        System.out.println(l.pathSumExists(root, 7));
        l.getPathSum(root, 14);
        System.out.println(l.paths);
    }
}
