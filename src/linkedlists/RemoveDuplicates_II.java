package linkedlists;

public class RemoveDuplicates_II {

    public <T extends Comparable<T>> ListNode<T> deleteDuplicates(ListNode<T> head) {
        ListNode<T> curr = head;

//        while (curr != null) {
//            ListNode<T> next = curr.next;
//            while(curr.next != null && curr.val == next.val)
//                next = next.next;
//            curr.next = next;
//            curr = next;
//        }
        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val)
                curr.next = curr.next.next;
            curr = curr.next;
        }
        return head;
    }

    public <T extends Comparable<T>> ListNode<T> deleteDuplicates_II(ListNode<T> head, int k) {
        ListNode<T> dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode<T> curr = dummyHead.next, prev = dummyHead;

        while(curr != null) {
            int count = 1;
            ListNode<T> next = curr.next;
            ListNode<T> nextPrev = curr;
            while(curr.next != null && next.val == curr.val) {
                count++;
                nextPrev = next;
                next = next.next;
            }

            if(count > k ) {
                prev.next = next;
            } else
                prev = nextPrev;
            curr = next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

        ListNode<Integer> listNode = LinkedList.create(new Integer[]{1,2,3,3,3,4,4,5});
        LinkedList.print(new RemoveDuplicates_II().deleteDuplicates(listNode));
        listNode = LinkedList.create(new Integer[]{1,2,3,3,3,4,4,5});
        LinkedList.print(new RemoveDuplicates_II().deleteDuplicates_II(listNode, 3));
    }
}
