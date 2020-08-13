package linkedlists;

public class DetectCycle {

    public static boolean detectCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;

        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
