package commons;

import trees.TreeNode;

public class BinarySearchTree {
	
	public static int counter = 0;
	
	public static void getInorder(TreeNode node, int[] inorder) {
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
	
	public static void printInorder(TreeNode node) {
		
		if(node!= null) {
			printInorder(node.left);
			System.out.print(node.data+" ");
			printInorder(node.right);
		}
	}
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node2.left = node1;
		node2.right = node4;
		node3.left = node2;
		node3.right = node5;
		
		TreeNode root = node3;
		
		
		int[] inorder = new int[5];
		getInorder(root, inorder);
		System.out.println("isBST: "+ isBST(inorder));
		
		
	}
}
