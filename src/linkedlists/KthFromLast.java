package linkedlists;

public class KthFromLast {

    /**
     * The idea behind this approach is we have two pointers a and b.
     * Now move pointer a to K position ahead of b. Now start iterating through nodes a and b with same pace.
     * When a hits null, simply return b. Because a is always k step ahead of b.
     * @param head
     * @param K
     * @return
     */
    public <T extends Comparable<T>> ListNode<T> findKthApproach2(ListNode<T> head, int K) {
        ListNode p1 = head, p2 = head;

        for(int i=0; i<K; i++) {
            if (p2 == null) return null; // out of bounds
            p2 = p2.next;
        }

        while(p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    public <T extends Comparable<T>> ListNode<T> findKth(ListNode<T> head, int k) {
        ListNode<T> curr = head;
        int len = LinkedList.length(head), i =0;

        while(curr != null && len - i > k) {
            curr = curr.next;
            i++;
        }

        return curr;
    }

    public static void main(String[] args) {
        System.out.println(new KthFromLast().findKth(LinkedList.create(new Integer[]{1,2,3,4,5}), 2).val);
        System.out.println(new KthFromLast().findKth(LinkedList.create(new Integer[]{1,2,3,4}), 3).val);
        System.out.println(new KthFromLast().findKthApproach2(LinkedList.create(new Integer[]{1,2,3,4,5,6}), 4).val);
    }
}
