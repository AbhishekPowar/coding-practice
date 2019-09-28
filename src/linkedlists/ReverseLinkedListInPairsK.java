package linkedlists;

public class ReverseLinkedListInPairsK {

    public ListNode reverse(ListNode head, int k) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        int count = 0;

        while(count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if(next != null)
            head.next = reverse(next, k);

        return prev;
    }
    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode reversed = new ReverseLinkedListInPairsK().reverse(n1, 2);

        ListNode node = reversed;

        while(node!= null) {
            System.out.println(node.val+"  ");
            node = node.next;
        }
    }
}
