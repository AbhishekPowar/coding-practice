package linkedlists;

public class RemoveDuplicates_II {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {
            if(curr.next != null && curr.next.val == curr.val) {
                ListNode l = curr.next;
                while(l != null && l.val == curr.val)
                    l = l.next;
                curr = l;
            } else {
                if(prev == null) {
                    head = curr;
                } else {
                    prev.next = curr;
                }
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new LinkedList().create(new int[]{1,2,3,3,4,4,5});
        new RemoveDuplicates_II().deleteDuplicates(listNode);
    }
}
