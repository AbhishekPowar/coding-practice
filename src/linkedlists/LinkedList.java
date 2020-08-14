package linkedlists;

public class LinkedList<T extends Comparable<T>> {
    private ListNode<T> head;
    private int length;

    public LinkedList() {

    }
    public LinkedList(Integer[] ar) {
        head = new ListNode(ar[0]);
        ListNode<T> curr = head;
        for(int i=1; i<ar.length;i++) {
            curr.next = new ListNode(ar[i]);
            curr = curr.next;
            length++;
        }
    }

    public ListNode<T> getHead() {
        return this.head;
    }

    public static <T extends Comparable<T>> ListNode<T> create(T[] ar) {
        if(ar.length == 0)
            return null;
        ListNode<T> head = new ListNode<>(ar[0]);
        ListNode<T> curr = head;

        for(int i=1; i<ar.length;i++) {
            curr.next = new ListNode<>(ar[i]);
            curr = curr.next;
        }
        return head;
    }

    public static <T extends Comparable<T>> void print(ListNode<T> head) {
        while(head != null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }

    public int length() {
        return this.length;
    }

    public static <T extends Comparable<T>> int length(ListNode<T> node) {
        int len = 0;
        while(node != null) {
            node = node.next;
            len++;
        }
        return len;
    }
}
