package com.trees;

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
        if(node.left == null && node.right == null && node.data == sum)
            return true;

        List<Integer> list = new ArrayList<>();
        list.add(node.data);

        if(pathSumExists(node.left, sum - node.data)) {
            list.add(node.left.data);
        }

        if(pathSumExists(node.right, sum - node.data)) {
            list.add(node.right.data);
        }
        return pathSumExists(node.left, sum - node.data) || pathSumExists(node.right, sum - node.data);
    }

    private void getPaths(TreeNode node, int sum, List<Integer> path) {
        if(node == null)
            return;

        path.add(node.data);

        if(node.left == null && node.right == null && node.data == sum) {
            paths.add(new ArrayList<>(path));
            path.remove(path.size() -1 );
            return;
        }

        getPaths(node.left, sum - node.data, path);
        getPaths(node.right, sum - node.data, path);
        path.remove(path.size() - 1);
    }
    private int pathCount(TreeNode node, int sum) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null && node.data == sum)
            return 1;

        return pathCount(node.left, sum - node.data) + pathCount(node.right, sum - node.data);
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
