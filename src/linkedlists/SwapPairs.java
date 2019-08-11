package linkedlists;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null)
            return head;

        if(head.next != null) {
            ListNode temp = swapPairs(head.next.next);

            ListNode nextNode = head.next;
            nextNode.next = head;
            nextNode.next.next = temp;

            return nextNode;
        } else {
            return head;
        }
    }

    public void printList(ListNode head) {
        ListNode temp = head;

        while(temp != null) {
            System.out.println(temp.val+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);;
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        ListNode head = node1;

        SwapPairs swapPairs = new SwapPairs();
        ListNode swappedList = swapPairs.swapPairs(head);
        swapPairs.printList(swappedList);
    }
}
