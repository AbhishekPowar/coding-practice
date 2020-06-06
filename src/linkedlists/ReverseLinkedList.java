package linkedlists;

import java.util.Arrays;

public class ReverseLinkedList {

    public ListNode reverse(ListNode node) {
        ListNode prev = null, curr = node, next;

        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4  = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode reversed = new ReverseLinkedList().reverse(n1);
        ListNode node = reversed;
        while(node!= null) {
            System.out.println(node.val+"  ");
            node = node.next;
        }

        int[] a = {4,3,2,1};
        Arrays.sort(a);
        Arrays.stream(a).forEach(System.out::println);
    }
}
