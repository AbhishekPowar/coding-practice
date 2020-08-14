package linkedlists;

public class CyclicRightShift {

    public static ListNode<Integer> rightShift(ListNode<Integer> head, int k) {
        ListNode<Integer> p1 = head, p2 = head;

        while (k+1> 0 && p1 != null) {
            p1 = p1.next;
            k--;
        }
        if(p1 == null)
            return head;
        ListNode<Integer> endNode = null;

        while(p1 != null) {
            endNode = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        endNode.next = head;
        head = p2.next;
        p2.next = null;

        return head;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(new Integer[]{1,2,3,4,5});

        ListNode<Integer> rightShift = rightShift(linkedList.getHead(), 2);
        LinkedList.print(rightShift);

        rightShift = rightShift(rightShift, 3);
        LinkedList.print(rightShift);
    }
}
