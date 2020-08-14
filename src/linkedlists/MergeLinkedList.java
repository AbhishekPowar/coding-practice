package linkedlists;

public class MergeLinkedList {

    public static ListNode<Integer> merge(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> dummyHead = new ListNode<>(-1);
        ListNode<Integer> curr = dummyHead;
        ListNode<Integer> p1 = l1, p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val <= p2.val) {
                curr.next = p1;
                p1 = p1.next;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            curr = curr.next;
        }

        curr.next = p1 == null ? p2 : p1;
        return dummyHead.next;
    }
    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<>(new Integer[] {1,2,3,4,5});
        LinkedList<Integer> l2 = new LinkedList<>(new Integer[] {6,7,8,9,});

        ListNode<Integer> merged = merge(l1.getHead(), l2.getHead());

        LinkedList.print(merged);
    }
}
