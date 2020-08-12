package linkedlists;

public class LinkedList {
    private ListNode head;
    private int length;

    public LinkedList() {

    }
    public LinkedList(int[] ar) {
        head = new ListNode(ar[0]);
        ListNode curr = head;
        for(int i=1; i<ar.length;i++) {
            curr.next = new ListNode(ar[i]);
            curr = curr.next;
            length++;
        }
    }

    public ListNode getHead() {
        return this.head;
    }

    public static ListNode create(int[] ar) {
        if(ar.length == 0)
            return null;
        ListNode head = new ListNode(ar[0]);
        ListNode curr = head;

        for(int i=1; i<ar.length;i++) {
            curr.next = new ListNode(ar[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public int length() {
        return this.length;
    }

    public static int length(ListNode node) {
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
