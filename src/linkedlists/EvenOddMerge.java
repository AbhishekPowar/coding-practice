package linkedlists;

public class EvenOddMerge {
    public static ListNode<Integer> merge(ListNode<Integer> list) {

        if(list == null)
            return null;

        ListNode<Integer> dummyEvenHead = new ListNode<>(-1), dummyOddHead = new ListNode<>(-1);
        ListNode<Integer> odd = dummyOddHead, even = dummyEvenHead, curr = list;

        int turn = 0;

        while(curr != null) {
            if((turn&1) == 0) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            curr = curr.next;
            turn ^= 1; //flip value 
        }

        odd.next = null;
        even.next = dummyOddHead.next;

        return dummyEvenHead.next;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(new Integer[]{1,2,3,4,5});
        LinkedList.print(merge(linkedList.getHead()));
    }
}
