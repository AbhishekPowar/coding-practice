package linkedlists;

public class ReverseBetweenLL {
    public ListNode reverseBetween(ListNode head, int  m, int n) {

        ListNode l = new ListNode(-1), curr;
        curr = l;
        l.next = head;

        int start = 0, endIdx = m-2;;

        while(start < m-1) {
            curr = curr.next;
            start++;
        }

        ListNode startNode = curr, end = curr.next, prev = null, next;
        curr = curr.next;

        while(endIdx < n-1) {
            next = curr.next;
            curr.next = prev;
            prev  = curr;
            curr = next;
            endIdx++;
        }

        startNode.next = prev;
        end.next = curr;

        return l.next;
    }

    public static ListNode reverseSublist(ListNode head, int start, int end) {

        if(start <= 0)
            throw new IllegalArgumentException("Invalid Bounds");
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode curr = dummyHead.next, pre  = dummyHead;

        while(start-1 > 0 && curr != null) {
            pre = curr;
            curr = curr.next;
            start--;
        }

        if(curr == null && start > 0)
            throw new IllegalArgumentException("Invalid Bounds");

        ListNode prev = null;

        while(end > 0 && curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            end--;
        }

        if(curr == null && end > 0)
            throw new IllegalArgumentException("Invalid Bounds");

        pre.next.next = curr;
        pre.next = prev;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        LinkedList.print(new ReverseBetweenLL().reverseBetween(LinkedList.create(new int[]{1,2,3,4,5}), 2,4));
        LinkedList.print(reverseSublist(LinkedList.create(new int[]{1,2,3,4,5}), 1,2));
    }
}
