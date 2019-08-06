package commons;

import java.util.Stack;

class Node {
	public Node next;
	public int data;
	
	Node(int data) {
		this.data = data;
	}
	public int getData() {
		return data;
	}
}
public class LinkedListAlternateSubtract {
	
	public static void subtract(Node node) {

		Stack<Node> stack = new Stack<Node>();
		
		Node t = node;
		while(t!= null) {
			stack.push(t);
			t = t.next;
		}
		
		Node temp = node;
		Node jump = node.next;
		
		while(jump != null) {
			temp.data = temp.getData() - stack.pop().getData(); 
			temp = temp.next;
			jump = jump.next.next;
		}
		
		print(node);
	}
	public static void print(Node node) {
		Node temp = node;
		
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.next;
		}
	}
	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(4);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(8);
		Node node6 = new Node(1);
		Node node7 = new Node(2);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		Node head = node1;
		
		subtract(head);
	}
}
