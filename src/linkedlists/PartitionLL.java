package linkedlists;

/**
 * Problem statement
 * Partition a linked list around some value x, such that all the elements < x are before all the elements great then x including x
 *
 * e.g, [3,5,8,5,10,2,1]  and x = 5
 * o/p: [3,1,2,5,8,5,10]   order of elements after moving elements < x does not matter
 */
public class PartitionLL {

    /**
     * A two pointer approach to partition linked list
     * @param head
     * @param x
     * @return
     */
    public ListNode<Integer> approach2(ListNode<Integer> head, int x) {
        ListNode<Integer> smallerHead = new ListNode<>(0), largerHead = new ListNode<>(0);
        ListNode<Integer> smaller = smallerHead, larger = largerHead;

        while(head != null) {
            if(head.val < x)
                smaller = smaller.next = head;
            else
                larger = larger.next = head;
            head = head.next;
        }

        smaller.next = largerHead.next;
        larger.next = null;
        return smallerHead.next;
    }
    public ListNode<Integer> partition(ListNode<Integer> head, int partition) {
        ListNode<Integer> curr = head, l1 = null, l2 = null, left = null, right = null;

        while (curr != null) {
            if(curr.val < partition) {
                if(l1 == null) {
                    l1 = curr;
                    left = l1;
                } else {
                    left.next = curr;
                    left = curr;
                }
            } else {
                if(l2 == null) {
                    l2 = curr;
                    right = l2;
                } else {
                    right.next = curr;
                    right = curr;
                }
            }
            curr = curr.next;
        }

        if(right != null) right.next = null;
        if(left != null) left.next = l2;

        return l1 == null? l2 :l1;
    }

    public static void main(String[] args) {
        LinkedList.print(new PartitionLL().partition(LinkedList.create(new Integer[]{3,5,8,5,10,2,1}), 5));
        LinkedList.print(new PartitionLL().partition(LinkedList.create(new Integer[]{5,8,5,10}), 5));
    }
}
