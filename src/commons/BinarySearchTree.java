package com.commons;

// Node Class
class Node {
	Node left;
	Node right;
	int data;
	
	Node(int data) {
		left = right = null;
		this.data = data;
	}
}
public class BinarySearchTree {
	
	public static int counter = 0;
	
	public static void getInorder(Node node, int[] inorder) {
		if(node!= null) {
			getInorder(node.left, inorder);
			inorder[counter] = node.data;
			counter++;
			getInorder(node.right, inorder);
		}
	}
	public static boolean isBST(int[] inorder) {
		
		for(int i=0; i<inorder.length-1; i++) {
			if(inorder[i] > inorder[i+1])
				return false;
		}
		return true;
	}
	
	public static void printInorder(Node node) {
		
		if(node!= null) {
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		
		node2.left = node1;
		node2.right = node4;
		node3.left = node2;
		node3.right = node5;
		
		Node root = node3;
		
		
		int[] inorder = new int[5];
		getInorder(root, inorder);
		System.out.println("isBST: "+ isBST(inorder));
		
		
	}
}
