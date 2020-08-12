package linkedlists;

public class MergeLinkedList {

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        ListNode p1 = l1, p2 = l2;

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
        LinkedList l1 = new LinkedList(new int[] {1,2,3,4,5});
        LinkedList l2 = new LinkedList(new int[] {6,7,8,9,});

        ListNode merged = merge(l1.getHead(), l2.getHead());

        LinkedList.print(merged);
    }
}
