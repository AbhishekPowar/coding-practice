package commons;

import java.util.Stack;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }
public class PallindromicLinkedLIst {
	public static boolean isPallindromic(ListNode list) {
		
		if(list == null)
			return false;
		
		Stack<Integer> stack = new Stack<>();
		
		ListNode temp = list;
		
		while(temp!= null) {
			stack.push(temp.val);
			temp = temp.next;
		}
		
		temp = list;
		while(temp != null ) {
			int data = stack.pop();
			if(temp.val != data)
				return false;
			
			temp = temp.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(1);
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;
		ListNode list = node1;
		
		
		System.out.println(isPallindromic(list));
		
		String s = "Hello!";
		s = s.toLowerCase();
		System.out.println(s);
	}
}
