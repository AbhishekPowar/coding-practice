package design;

import commons.BinarySearchTree;

/**
 * Design HashSet without using Build-In HashSet libraries
 */
public class CustomHashSet {

    private Bucket[] buckets;
    private int bucketSize;

    public CustomHashSet(int bucketSize) {
        this.bucketSize = bucketSize;
        buckets = new Bucket[this.bucketSize];

        for(int i=0; i<this.bucketSize; i++)
            buckets[i] = new Bucket();
    }

    public void add(int value) {
        buckets[_hash(value)].add(value);
    }

    public void remove(int value) {
        buckets[_hash(value)].remove(value);
    }

    public boolean contains(int value) {
        return buckets[_hash(value)].contains(value);
    }
    private int _hash(int value) {
        return value % this.bucketSize;
    }
}

class Bucket {
    BSTree<Integer> bsTree;
    public Bucket() {
        bsTree = new BSTree<Integer>();
    }
    public void add(int value) {
        this.bsTree.add(value);
    }
    public void remove(int value) {
        this.bsTree.remove(value);
    }
    public boolean contains(int value) {
        return this.bsTree.contains(value);
    }
}

class TreeNode<T extends Comparable<T>> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BSTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public BSTree() {

    }

    public void add(T value) {
        if(root == null)
            this.root = new TreeNode<>(value);
        add(this.root, value);
    }

    private TreeNode<T> add(TreeNode<T> node, T value) {
        if(node == null)
            return new TreeNode<>(value);

        if(node.val.compareTo(value) < 0) {
            node.right = add(node.right, value);
        } else
            node.left = add(node.left, value);
        return node;
    }

    public void remove(T value) {
        remove(this.root, null, value);
    }

    private void remove(TreeNode<T> node, TreeNode<T> parent, T value) {
        if(node == null) return;

        if(value.compareTo(node.val) < 0)
            remove(node.left, node, value);
        else if(value.compareTo(node.val) > 0)
            remove(node.right, node, value);
        else {
            if(node == parent.left) {
                if(node.left == null)
                    parent.left = node.right;
                else if(node.right == null)
                    parent.left = node.left;
                else {
                    parent.left = node.left;
                    TreeNode<T> right = parent.left.right;
                    parent.left.right = node.right;

                    TreeNode<T> successor = findNode(node.right);
                    successor.left = right;
                }
            } else {
                if(node.left == null)
                    parent.right = node.right;
                else if(node.right == null)
                    parent.right = node.left;
                else {
                    parent.right = node.left;
                    TreeNode<T> right = parent.left.right;
                    parent.left.right = node.right;

                    TreeNode<T> successor = findNode(node.right);
                    successor.left = right;
                }
            }
        }
    }

    private TreeNode<T> findNode(TreeNode<T> node) {
        if(node.left == null)
            return node;
        return findNode(node.left);

    }

    public boolean contains(T value) {
        return contains(this.root, value);
    }

    private boolean contains(TreeNode<T> root, T value) {
        if(root == null)
            return false;
        if(root.val.compareTo(value) == 0)
            return true;
        return contains(root.left, value) || contains(root.right, value);
    }
}
